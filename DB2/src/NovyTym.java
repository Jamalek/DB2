import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NovyTym extends JDialog{
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JTextField tf_nazevTymu = new JTextField();
	private JTextField tf_hriste = new JTextField();
	private JButton bu_potvrzeni = new JButton();
	
	public NovyTym() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Nový tým");
		setSize(new Dimension(230, 120));
        init();
		setLocationRelativeTo(null);
		setVisible(true);
 	}

	private void init() {
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Název týmu:");
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Domovské hřiště:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        tf_nazevTymu.setMinimumSize(new java.awt.Dimension(100, 20));
        tf_nazevTymu.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(tf_nazevTymu, gridBagConstraints);

        tf_hriste.setMinimumSize(new java.awt.Dimension(100, 20));
        tf_hriste.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(tf_hriste, gridBagConstraints);

        bu_potvrzeni.setText("Potvrdit");
        bu_potvrzeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (tf_nazevTymu.getText().equalsIgnoreCase("")) {
                	setTitle("Zadejte název týmu.");
                } else if (DB.tymExistuje(tf_nazevTymu.getText())) {
                	setTitle("Tým existuje!");
                } else if (tf_hriste.getText().equalsIgnoreCase("")) {
                	setTitle("Zadejte název místa");
                } else {
                	dispose();
                	DB.novyTym(tf_nazevTymu.getText(), tf_hriste.getText());
                	Ramec.tymy=DB.nactiTymy();
                	Ramec.instance.dispose();
                	Ramec.start();
                }
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(bu_potvrzeni, gridBagConstraints);
	}
}
