import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NovyTym extends JDialog{
	JTable table;
	DefaultTableModel model;
	
	public NovyTym() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(200, 103));
		setLocationRelativeTo(null);
		setTitle("Nový tým");
		setVisible(true);
        JScrollPane sp = new JScrollPane();
        createTable();
        sp.setViewportView(table);
        getContentPane().add(sp, java.awt.BorderLayout.CENTER);
        JButton ulozit = new JButton("Uložit nový tým");
        add(ulozit, java.awt.BorderLayout.PAGE_END);
	}

	private void createTable() {
		table = new JTable();
		model = new DefaultTableModel(
                new Object [1][2], new String [] {"Název", "Domovské hřiště"}) {
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return true;
                }
            };
        table.setModel(model);
	}
}
