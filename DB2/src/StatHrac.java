import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatHrac extends JDialog{
	JTable table;
	DefaultTableModel model;
	
	public StatHrac() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(1000, 500));
		setLocationRelativeTo(null);
		setTitle("Žebříček hráčů");
		setVisible(true);
        JScrollPane sp = new JScrollPane();
        createTable();
        sp.setViewportView(table);
        getContentPane().add(sp, java.awt.BorderLayout.CENTER);
	}

	private void createTable() {
		table = new JTable();
		model = new DefaultTableModel(
                new Object [0][9], new String [] {"Jméno", "Příjmení", "D. narození", "Váha", "Post", "Góly", "Zápasů celkem", "Zápasů doma", "Zápasů venku"}) {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
        DB.naplnHrace(model,"HRAC_Z1_BRANKY");
        table.setModel(model);
        table.getTableHeader().addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int col = table.columnAtPoint(e.getPoint());
 				switch (col) {
				case 4:
					DB.naplnHrace(model, "HRAC_Z3_POST");
					break;
				case 5:
					DB.naplnHrace(model, "HRAC_Z1_BRANKY");
					break;
				case 6:
					DB.naplnHrace(model, "HRAC_Z2_Z_CELKEM");
					break;
				case 7:
					DB.naplnHrace(model, "HRAC_Z2_Z_DOMA");
					break;
				case 8:
					DB.naplnHrace(model, "HRAC_Z2_Z_VENKU");
					break;
				default:
					break;
				}
			}
        });
	}
}
