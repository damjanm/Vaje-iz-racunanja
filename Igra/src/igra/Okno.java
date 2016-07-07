package igra;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JButton;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@SuppressWarnings("serial")
public class Okno extends JFrame implements MenuListener, ActionListener {
	public Platno platno;
	public Timer timer;
	
	JButton zacni;
	public Okno(){
		super();
		setTitle("Vaje iz računanja");
		this.platno = new Platno(500, 400);
		this.getContentPane().add(platno);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		
		JMenuBar mb = new JMenuBar();
		
		JMenu menu = new JMenu("Menu");
		mb.add(menu);
		JMenuItem newGame = new JMenuItem("Nova igra");
		menu.add(newGame);
		newGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				platno.zacetek();
				platno.getRootPane().setDefaultButton(platno.zacni);
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