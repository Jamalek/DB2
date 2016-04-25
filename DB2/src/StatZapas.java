import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatZapas extends JDialog{
	JTable table;
	DefaultTableModel model;
	
	public StatZapas() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(300, 200));
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
                new Object [0][3], new String [] {"Tým 1", "Výsledek zápasu", "Tým 2"}) {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
        DB.naplnZapasy(model);
        table.setModel(model);
	}
}
