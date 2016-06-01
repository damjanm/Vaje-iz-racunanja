package igra;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Okno extends JFrame {
	public Platno platno;
	
	public Okno(){
		super();
		setTitle("naslov");		
		this.platno = new Platno(600, 600);
		add(platno);
		
	}
	public static void main(String[] args) {
		Okno okno = new Okno();
		okno.pack();
		okno.setVisible(true);
	}
}
