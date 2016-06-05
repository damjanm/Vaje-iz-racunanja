package igra;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class Okno extends JFrame implements MouseListener {
	public Platno platno;
	JButton zacni;
	
	public Okno(){
		super();
		setTitle("naslov");
		this.platno = new Platno(500, 400);
		this.getContentPane().add(platno);
		this.addMouseListener(this);
		//this.setLayout(new GridBagLayout());
		

	}
	public static void main(String[] args) {
		Okno okno = new Okno();
		okno.pack();
		okno.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()== zacni){
//			repaint();
//		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
