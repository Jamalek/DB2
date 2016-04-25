import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NovyHrac extends JDialog{
    private javax.swing.JTextField tf_dn_den;
    private javax.swing.JTextField tf_dn_mesic;
    private javax.swing.JTextField tf_dn_rok;
    private javax.swing.JTextField tf_jmeno;
    private javax.swing.JTextField tf_prijmeni;
    private javax.swing.JTextField tf_vaha;
    private java.awt.Choice ch_post;
    private java.awt.Choice ch_nazevTymu;
	static ArrayList<Tym> tymy = new ArrayList<Tym>();
	
	public NovyHrac() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Nový hráč");
		setSize(new Dimension(230, 230));
        init();
		setLocationRelativeTo(null);
		setVisible(true);
 	}

    private void init() {
        getContentPane().setLayout(new java.awt.GridBagLayout());

        JLabel jLabel3 = new JLabel("Jméno:");
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        JLabel jLabel4 = new JLabel("Příjmení:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        JLabel jLabel5 = new JLabel("Datum narození:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        JLabel jLabel8 = new JLabel(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        JLabel jLabel9 = new JLabel(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 0);
        getContentPane().add(jLabel9, gridBagConstraints);

        JLabel jLabel6 = new JLabel("Váha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        JLabel jLabel10 = new JLabel("Post:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        getContentPane().add(jLabel10, gridBagConstraints);

        JLabel jLabel7 = new JLabel("Název týmu:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        tf_jmeno = new JTextField();
        tf_jmeno.setMinimumSize(new java.awt.Dimension(100, 20));
        tf_jmeno.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(tf_jmeno, gridBagConstraints);

        tf_prijmeni = new JTextField();
        tf_prijmeni.setMinimumSize(new java.awt.Dimension(100, 20));
        tf_prijmeni.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(tf_prijmeni, gridBagConstraints);

        tf_dn_rok = new JTextField();
        tf_dn_rok.setMinimumSize(new java.awt.Dimension(40, 20));
        tf_dn_rok.setPreferredSize(new java.awt.Dimension(40, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        getContentPane().add(tf_dn_rok, gridBagConstraints);

        tf_vaha = new JTextField();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(tf_vaha, gridBagConstraints);

        tf_dn_mesic = new JTextField();
        tf_dn_mesic.setPreferredSize(new java.awt.Dimension(25, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        getContentPane().add(tf_dn_mesic, gridBagConstraints);

        tf_dn_den = new JTextField();
        tf_dn_den.setPreferredSize(new java.awt.Dimension(25, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        getContentPane().add(tf_dn_den, gridBagConstraints);
        
        ch_post = new java.awt.Choice();
        ch_post.add("Brankář");
        ch_post.add("Obránce");
        ch_post.add("Záložník");
        ch_post.add("Útočník");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(ch_post, gridBagConstraints);
        
        tymy = DB.nactiTymy();
        ch_nazevTymu = new java.awt.Choice();
        for (Tym tym : tymy) {
        	ch_nazevTymu.add(tym.nazev);
		}
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(ch_nazevTymu, gridBagConstraints);

        JButton b_potvrzeni = new JButton("Potvrdit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        getContentPane().add(b_potvrzeni, gridBagConstraints);
        b_potvrzeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				String post = "";
				switch (ch_post.getSelectedItem().charAt(0)) {
				case 'B': post="BRANKAR"; break;
				case 'O': post="OBRANCE"; break;
				case 'Z': post="ZALOZNIK"; break;
				case 'U': post="UTOCNIK"; break;
				default: break; }
				DB.novyHrac(
						tf_jmeno.getText(), 
						tf_prijmeni.getText(), 
						tf_dn_rok.getText()+"-"+
						(tf_dn_mesic.getText().length()==2?tf_dn_mesic.getText():"0"+tf_dn_mesic.getText())+"-"+
						(tf_dn_den.getText().length()==2?tf_dn_den.getText():"0"+tf_dn_den.getText()), 
						tf_vaha.getText(), 
						post, 
						ch_nazevTymu.getSelectedItem());
			}
		});
	}
}
