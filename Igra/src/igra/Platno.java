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
	public JTextField textField;
	public String r;
	public JTextField odgovor;
	public String rr;
	private int st_3;
	public int stevec = 0;
	public int stevec_resenih_nalog = 0;
	public int a;
	public JRadioButton ButtonPet;
	public JRadioButton ButtonDeset;
	public JRadioButton ButtonPetnajst;
	public JRadioButton ButtonDvajset;
	public JLabel VnesiIme;
	public JLabel lblNewLabel;
	public JButton zacni;
	
	public Platno(int sirina, int visina){
		super();		

		this.sirina = sirina;
		this.visina = visina;
		
	
		zacni = new JButton("Začni!");
		zacni.setBounds(175, 197, 107, 23);
		zacni.setForeground(Color.BLACK);
		zacni.setBackground(Color.WHITE);
		
		ButtonPet = new JRadioButton("5");
		ButtonPet.setBounds(107, 165, 40, 23);
		
		ButtonDeset = new JRadioButton("10");
		ButtonDeset.setBounds(158, 165, 48, 23);
		
		ButtonPetnajst = new JRadioButton("15");
		ButtonPetnajst.setBounds(218, 165, 48, 23);
		
		ButtonDvajset = new JRadioButton("20");
		ButtonDvajset.setBounds(278, 165, 48, 23);
		
		textField = new JTextField();
		textField.setBounds(103, 93, 239, 23);
				
		VnesiIme = new JLabel(" Vnesi ime:");
		VnesiIme.setBounds(191, 68, 69, 14);
				
		lblNewLabel = new JLabel("Koliko računov želiš rešiti?");
		lblNewLabel.setBounds(143, 137, 168, 16);
		
		
		
		this.zacetek(ButtonPet, ButtonDeset, ButtonPetnajst, ButtonDvajset, textField, zacni, VnesiIme, lblNewLabel);
		
		setLayout(null);
	
	}
	public void zacetek(JRadioButton buttonPet, JRadioButton buttonDeset, JRadioButton buttonPetnajst, JRadioButton buttonDvajset, JTextField textField, JButton zacni, JLabel VnesiIme, JLabel lblNewLabel){
		stevec = 0;
		stevec_resenih_nalog = 0;
		
		this.add(buttonPet);
		
		this.add(buttonDeset);
		
		this.add(buttonPetnajst);
		
		this.add(buttonDvajset);
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(buttonPet);
		bG.add(buttonDeset);
		bG.add(buttonPetnajst);
		bG.add(buttonDvajset);
		buttonPet.setSelected(true);

		if(buttonPet.isSelected()){
			a = 5;
		}
		else if(buttonDeset.isSelected()){
			a = 10;
		}
		else if(buttonPetnajst.isSelected()){
			a = 15;
		}
		else if(buttonDvajset.isSelected()){
			a = 20;
		}

		
		add(textField);
		textField.setColumns(10);
		add(zacni);
		
		add(VnesiIme);
		
		
		this.add(lblNewLabel);

		zacni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					generiraj_nalogo();			

			}
		});
	}
	
	public int ocena(int st_resenih_nalog, int a){
		int b = st_resenih_nalog/a;
		if(b>=0.9){ return 5;}
		if(b>=0.8){ return 4;}
		if(b>=0.7){ return 3;}
		if(b>=0.6){ return 2;}
		return 1;
		
		
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
					if(textField.getText().isEmpty()){ textField.setText("Igralec");} 
					JLabel kuku = new JLabel(textField.getText() + ", pravilno si rešil/a " + Integer.toString(stevec_resenih_nalog) + " nalog. Dosegel/la si oceno" + " " + Integer.toString(ocena(stevec_resenih_nalog,a)) + ".");
					kuku.setBounds(131, 118, 469, 14);
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
