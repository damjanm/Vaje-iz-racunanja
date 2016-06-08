package igra;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@SuppressWarnings("serial")
public class Okno extends JFrame implements MouseListener, MenuListener, ActionListener {
	public Platno platno;
	JButton zacni;
	public Okno(){
		super();
		setTitle("Vaje iz računanja");
		this.platno = new Platno(500, 400);
		this.getContentPane().add(platno);
		
		this.addMouseListener(this);
		//this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		
		JMenuBar mb = new JMenuBar();
		
		JMenu menu = new JMenu("Menu");
		mb.add(menu);
		JMenuItem newGame = new JMenuItem("Nova igra");
		menu.add(newGame);
		newGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//this.platno.zacetek( platno.ButtonPet, platno.ButtonDeset, platno.ButtonPetnajst, platno.ButtonDvajset, platno.textField, platno.zacni, platno.VnesiIme, platno.lblNewLabel);
			}
		}
		);
		
		JMenuItem exitGame = new JMenuItem("Izhod iz igre");
		menu.add(exitGame);
        exitGame.addActionListener(new exitApp());
		
		this.setJMenuBar(mb);
		

	}
	public static void main(String[] args) {
		Okno okno = new Okno();
		okno.pack();
		okno.setVisible(true);
		
	}
	// Exit app
    static class exitApp implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
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
	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}