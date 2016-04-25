import java.sql.*;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class DB {
	public static Connection con;
	
	public static void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@students.kiv.zcu.cz:1521:students", "malek",
					"A15N0016P");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
    }

	public static ArrayList<Tym> nactiTymy() {
		ArrayList<Tym> tymy = new ArrayList<Tym>();
		Statement stmt = null;
		String query = "SELECT id, nazev FROM tym";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				tymy.add(new Tym(Integer.parseInt(rs.getString("id")),rs.getString("nazev")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
		}
		return tymy;
	}

	public static ArrayList<Hrac> nactiHrace(int tid) {
		ArrayList<Hrac> hraci = new ArrayList<Hrac>();
		Statement stmt = null;
		String query = "SELECT hrac.id, hrac.jmeno, hrac.prijmeni FROM hrac, tym, soupiska WHERE hrac.id=soupiska.hrac_id AND soupiska.tym_id=tym.id AND tym.id="+tid;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				hraci.add(new Hrac(Integer.parseInt(rs.getString("id")),rs.getString("jmeno"),rs.getString("prijmeni")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
		}
		return hraci;
	}
	
	public static boolean novyZapas(int t1id, int t2id) {
		Statement stmt = null;
		String query = "INSERT INTO zapas VALUES("
				+ "seq_zapas.nextval, "
				+ "sysdate, "
				+ "(SELECT misto_id FROM tym WHERE tym.id="+t1id+"), "
				+ t1id +", "
				+ t2id +", "
				+ "0, "
				+ "0)";
		try {
			stmt = con.createStatement();
			stmt.executeQuery(query);
		} catch (SQLException e) {
			return false;
		} finally {
			closeStatement(stmt);
		}
		return true;
	}
	
	public static void gol(String typGolu, Hrac hrac, String cas) {
		Statement stmt = null;
		String query = "INSERT INTO branka VALUES("
				+ "seq_zapas.currval, "
				+ cas + ", "
				+ "'" + typGolu + "', "
				+ hrac.id + ")";
		try {
			stmt = con.createStatement();
			stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
		}
	}
	
	public static void updateSkore(JLabel label) {
		Statement stmt = null;
		String query = "SELECT skore1, skore2 FROM zapas WHERE id=(select max(id) from zapas)";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				label.setText(rs.getString("skore1")+":"+rs.getString("skore2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
		}
	}

	public static void aktualizace_poradi() {
		CallableStatement cl = null;
		try {
			cl = con.prepareCall("{call aktualizace_poradi()}");
			cl.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cl.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void naplnHrace(DefaultTableModel model, String tableName) {
		int rc = model.getRowCount();
		for (int i = 0; i < rc; i++) {
			model.removeRow(0);
		}
		Statement stmt = null;
		String query = "SELECT * FROM "+tableName;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("jmeno"),
						rs.getString("prijmeni"),
						rs.getString("d_narozeni").substring(0, 10),
						rs.getString("vaha"),
						rs.getString("post"),
						rs.getString("goly"),
						rs.getString("ZAPASU_CELKEM"),
						rs.getString("ZAPASU_DOMA"),
						rs.getString("ZAPASU_VENKU")
						});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
		}
	}

	public static void naplnTymy(DefaultTableModel model, String tableName) {
		int rc = model.getRowCount();
		for (int i = 0; i < rc; i++) {
			model.removeRow(0);
		}
		Statement stmt = null;
		String query = "SELECT * FROM "+tableName;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("NAZEV"),
						rs.getString("BODY"),
						rs.getString("PORADI"),
						rs.getString("ZAPASU_CELKEM"),
						rs.getString("ZAPASU_DOMA"),
						rs.getString("ZAPASU_VENKU")
						});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
		}
	}
	
	public static void naplnZapasy(DefaultTableModel model) {
		int rc = model.getRowCount();
		for (int i = 0; i < rc; i++) {
			model.removeRow(0);
		}
		Statement stmt = null;
		String query = "SELECT * FROM TYM_VYSLEDEK_ZAPASU";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("TYM1"),
						rs.getString("VYSLEDEK_ZAPASU"),
						rs.getString("TYM2"),
						});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeStatement(stmt);
		}
	}

	public static void vycistiDB() {
		CallableStatement cl = null;
		try {
			cl = con.prepareCall("{call VYMAZ_VSE()}");
			cl.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cl.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
