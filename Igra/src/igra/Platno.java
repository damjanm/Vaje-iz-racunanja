package igra;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
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
	private int st_3;
	public int stevec = 0;
	public int stevec_resenih_nalog = 0;
	
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
					generiraj_nalogo();			

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
	public void generiraj_nalogo(){
		removeAll();
		revalidate();
		repaint();
	    Random randomGenerator = new Random();
		int st_1 = randomGenerator.nextInt(100);
		int st_2 = randomGenerator.nextInt(100);
		st_3 = st_1 + st_2;
		JLabel vprasanje = new JLabel("Kolk je " + st_1 + "+" + st_2 + "?");
		vprasanje.setBounds(191, 118, 169, 14);
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
				if(rr.equals(Integer.toString(st_3))){
					++stevec_resenih_nalog;
				}
				removeAll();
				revalidate();
				repaint();
				if(stevec<=1){
					generiraj_nalogo();
					++stevec;
				}
				else{
					JLabel kuku = new JLabel(textField.getText() + " rešil si " + Integer.toString(stevec_resenih_nalog) + " nalog.");
					kuku.setBounds(191, 118, 469, 14);
					add(kuku);
				}
			}
		});
	}
	public Dimension getPreferredSize(){			
		return new Dimension(sirina, visina);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
