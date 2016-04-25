import javax.swing.JDialog;

public class DialogHrac extends JDialog{
	public Hrac hrac;
	
	public void aktivuj(Hrac hrac) {
		this.hrac = hrac;
		setVisible(true);
	}
}
