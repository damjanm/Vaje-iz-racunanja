package igra;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel {
	public int sirina;
	public int visina;
	
	public Platno(int sirina, int visina){
		super();		
		this.sirina = sirina;
		this.visina = visina;
	
	}
	
	public Dimension getPreferredSize(){			
		return new Dimension(sirina, visina);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
