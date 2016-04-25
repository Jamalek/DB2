import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatTym extends JDialog{
	JTable table;
	DefaultTableModel model;
	
	public StatTym() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(700, 500));
		setLocationRelativeTo(null);
		setTitle("Žebříček týmů");
		setVisible(true);
        JScrollPane sp = new JScrollPane();
        createTable();
        sp.setViewportView(table);
        getContentPane().add(sp, java.awt.BorderLayout.CENTER);
	}

	private void createTable() {
		table = new JTable();
		model = new DefaultTableModel(
                new Object [0][6], new String [] {"Název týmu", "Body", "Pořadí", "Zápasů celkem", "Zápasů doma", "Zápasů venku"}) {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
        DB.naplnTymy(model,"TYM_Z2_PORADI");
        table.setModel(model);
        table.getTableHeader().addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int col = table.columnAtPoint(e.getPoint());
 				switch (col) {
				case 1:
					DB.naplnTymy(model, "TYM_Z1_BODY");
					break;
				case 2:
					DB.naplnTymy(model, "TYM_Z2_PORADI");
					break;
				case 3:
					DB.naplnTymy(model, "TYM_Z3_ZAPASU_CELKEM");
					break;
				case 4:
					DB.naplnTymy(model, "TYM_Z4_ZAPASU_DOMA");
					break;
				case 5:
					DB.naplnTymy(model, "TYM_Z5_ZAPASU_VENKU");
					break;
				default:
					break;
				}
			}
        });
	}
}
