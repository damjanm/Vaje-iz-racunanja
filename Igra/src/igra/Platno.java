package igra;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Platno extends JPanel {
	public int sirina;
	public int visina;
	private JTextField textField;
	public String r;
	public JTextField odgovor;
	public String rr;
	
	public Platno(int sirina, int visina){
		super();		

		this.sirina = sirina;
		this.visina = visina;

		JButton zacni = new JButton("Za\u010Dni!");
		zacni.setBounds(175, 197, 107, 23);
		zacni.setForeground(Color.BLACK);
		zacni.setBackground(Color.WHITE);
		zacni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				revalidate();
				repaint();
				JLabel vprasanje = new JLabel("Kolk je 2+3?");
				vprasanje.setBounds(191, 118, 69, 14);
				add(vprasanje);
				odgovor = new JTextField();
				odgovor.setBounds(103, 143, 239, 23);
				add(odgovor);
				JButton gumb = new JButton("Odgovori");
				gumb.setBounds(175, 197, 107, 23);
				add(gumb);
				gumb.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						rr = odgovor.getText();
						if(rr.equals("5")){
							r = "Tocno!";
						}
						else{
							r = "Napacno!";
						}
						removeAll();
						revalidate();
						repaint();
						JLabel kuku = new JLabel(r);
						kuku.setBounds(191, 118, 69, 14);
						add(kuku);

					}
				});

			}
		});
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(103, 143, 239, 23);
		add(textField);
		textField.setColumns(10);
		add(zacni);
		
		JLabel VnesiIme = new JLabel(" Vnesi ime:");
		VnesiIme.setBounds(191, 118, 69, 14);
		add(VnesiIme);
	
	}
	
	public Dimension getPreferredSize(){			
		return new Dimension(sirina, visina);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
