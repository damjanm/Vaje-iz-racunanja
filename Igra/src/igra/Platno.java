package igra;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
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
	public int a;
	
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
		textField.setBounds(103, 93, 239, 23);
		add(textField);
		textField.setColumns(10);
		add(zacni);
		
		JLabel VnesiIme = new JLabel(" Vnesi ime:");
		VnesiIme.setBounds(191, 68, 69, 14);
		add(VnesiIme);
		
		JRadioButton ButtonPet = new JRadioButton("5");
		ButtonPet.setBounds(107, 165, 40, 23);
		this.add(ButtonPet);
		
		JRadioButton ButtonDeset = new JRadioButton("10");
		ButtonDeset.setBounds(158, 165, 48, 23);
		this.add(ButtonDeset);
		
		JRadioButton ButtonPetnajst = new JRadioButton("15");
		ButtonPetnajst.setBounds(218, 165, 48, 23);
		this.add(ButtonPetnajst);
		
		JRadioButton ButtonDvajset = new JRadioButton("20");
		ButtonDvajset.setBounds(278, 165, 48, 23);
		this.add(ButtonDvajset);
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(ButtonPet);
		bG.add(ButtonDeset);
		bG.add(ButtonPetnajst);
		bG.add(ButtonDvajset);
		ButtonPet.setSelected(true);

		if(ButtonPet.isSelected()){
			a = 5;
		}
		else if(ButtonDeset.isSelected()){
			a = 10;
		}
		else if(ButtonPetnajst.isSelected()){
			a = 15;
		}
		else if(ButtonDvajset.isSelected()){
			a = 20;
		}
	
		
		JLabel lblNewLabel = new JLabel("Koliko računov želiš rešiti?");
		lblNewLabel.setBounds(143, 137, 168, 16);
		this.add(lblNewLabel);
	
	}
	public void generiraj_nalogo(){
		removeAll();
		revalidate();
		repaint();
	    Random randomGenerator = new Random();
		int st_1 = randomGenerator.nextInt(100);
		int st_2 = randomGenerator.nextInt(100);
		st_3 = st_1 + st_2;
		JLabel vprasanje = new JLabel("Koliko je " + st_1 + "+" + st_2 + "?");
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
				if(stevec<= a+3){
					generiraj_nalogo();
					++stevec;
				}
				else{
					JLabel kuku = new JLabel(textField.getText() + ", rešil/a si " + Integer.toString(stevec_resenih_nalog) + " nalog.");
					kuku.setBounds(181, 118, 469, 14);
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
