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
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Platno extends JPanel {
	public int sirina;
	public int visina;
	public JTextField textField;
	public String r;
	public JTextField odgovor;
	public String rr;
	public int stevec = 0;
	public int stevec_resenih_nalog = 0;
	public int a = 0;
	public int ka = 0;
	public JRadioButton ButtonPet;
	public JRadioButton ButtonDeset;
	public JRadioButton ButtonPetnajst;
	public JRadioButton ButtonDvajset;
	public JLabel kaksne;
	public JRadioButton plusMinus;
	public JRadioButton kratDeljeno;
	public JRadioButton vseStiri;
	public JLabel VnesiIme;
	public JLabel lblNewLabel;
	public JLabel p;
	public int pr;
	public JButton zacni;
	private int operacija;
	public Timer timer;
	public JLabel cas;
	public int stevec_1;
	
	public Platno(int sirina, int visina){
		super();		

		this.sirina = sirina;
		this.visina = visina;
		
	
		zacni = new JButton("Za\u010Dni!");
		zacni.setBounds(165, 248, 107, 23);
		zacni.setForeground(Color.BLACK);
		zacni.setBackground(Color.WHITE);
		
		stevec_1 = 0;
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				++stevec_1;		
				cas.setText(Integer.toString(stevec_1));
			}
			
		});
		timer.stop();
		
		cas = new JLabel("0");
		cas.setBounds(50,50,40,40);
		
		p = new JLabel("");
		p.setBounds(400,50,40,40);
		
		ButtonPet = new JRadioButton("5");
		ButtonPet.setBounds(103, 212, 40, 23);
		

		ButtonPet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				a=5;
				
			}
		});
		
		
		ButtonDeset = new JRadioButton("10");
		ButtonDeset.setBounds(155, 212, 48, 23);


		ButtonDeset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				a=10;
				
			}
		});

		ButtonPetnajst = new JRadioButton("15");
		ButtonPetnajst.setBounds(215, 212, 48, 23);
		

		ButtonPetnajst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				a=15;
				
			}
		});

		ButtonDvajset = new JRadioButton("20");
		ButtonDvajset.setBounds(275, 212, 48, 23);
		

		ButtonDvajset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				a=20;
				
			}
		});

		textField = new JTextField();
		textField.setBounds(103, 52, 239, 23);
		textField.setText("Igralec");
				
		VnesiIme = new JLabel(" Vnesi ime:");
		VnesiIme.setBounds(190, 26, 69, 14);
				
		lblNewLabel = new JLabel("Koliko računov želiš rešiti?");
		lblNewLabel.setBounds(139, 184, 168, 16);
		
		kaksne = new JLabel("Kakšne račune želiš reševati?");
		kaksne.setBounds(136, 100, 187, 16);
		add(kaksne);
		
		plusMinus = new JRadioButton("+, -");
		plusMinus.setBounds(103, 128, 58, 23);
		plusMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ka=1;
			}
		});
		
		kratDeljeno = new JRadioButton("*, /");
		kratDeljeno.setBounds(173, 128, 58, 23);
		kratDeljeno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ka=2;
			}
		});
		
		vseStiri = new JRadioButton("+, -, *, /");
		vseStiri.setBounds(243, 128, 87, 23);
		vseStiri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ka=3;
			}
		});
		
		this.zacetek(plusMinus, kratDeljeno, vseStiri, ButtonPet, ButtonDeset, ButtonPetnajst, ButtonDvajset, textField, zacni, VnesiIme, lblNewLabel);
		
		setLayout(null);
		
		
	
	}
	public void zacetek(JRadioButton plusMinus, JRadioButton kratDeljeno, JRadioButton vseStiri, JRadioButton buttonPet, JRadioButton buttonDeset, JRadioButton buttonPetnajst, JRadioButton buttonDvajset, JTextField textField, JButton zacni, JLabel VnesiIme, JLabel lblNewLabel){
		stevec = 0;
		stevec_1 = 0;
		stevec_resenih_nalog = 0;
		pr = 1;
		removeAll();
		revalidate();
		repaint();
		
		cas.setText("0");
		this.add(buttonPet);		
		this.add(buttonDeset);		
		this.add(buttonPetnajst);		
		this.add(buttonDvajset);
		this.add(plusMinus);		
		this.add(kratDeljeno);		
		this.add(vseStiri);
		
		ButtonGroup bG = new ButtonGroup();
		bG.add(buttonPet);
		bG.add(buttonDeset);
		bG.add(buttonPetnajst);
		bG.add(buttonDvajset);
		if(a==5){buttonPet.setSelected(true);}
		else if(a==10){buttonDeset.setSelected(true);}
		else if(a==15){buttonPetnajst.setSelected(true);}
		else if(a==20){buttonDvajset.setSelected(true);}
		else{buttonPet.setSelected(true);}
		
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

		ButtonGroup bgr = new ButtonGroup();
		bgr.add(plusMinus);
		bgr.add(kratDeljeno);
		bgr.add(vseStiri);
		if(ka==1){plusMinus.setSelected(true);}
		else if(ka==2){kratDeljeno.setSelected(true);}
		else if(ka==3){vseStiri.setSelected(true);}
		else{vseStiri.setSelected(true);}
		
		if(plusMinus.isSelected()){
			ka = 1;
		}
		else if(kratDeljeno.isSelected()){
			ka = 2;
		}
		else if(vseStiri.isSelected()){
			ka = 3;
		}
		
		
		add(textField);
		textField.setColumns(10);
		add(zacni);
		
		add(VnesiIme);
		
		
		this.add(lblNewLabel);
		this.add(kaksne);

		zacni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					timer.start();
					generiraj_nalogo();			

			}
		});
	}
	
	public int ocena(int st_resenih_nalog, int a){
		double st = st_resenih_nalog;
		double vse = a;
		double b = st/vse;
		int c = 1;
		if(b>=0.9){ c = 5;}
		if(b<0.9 && b>=0.8){ c = 4;}
		if(b<0.8 && b>=0.7){ c = 3;}
		if(b<0.7 && b>=0.6){ c = 2;}
		return c;
		
		
	}
	public void generiraj_nalogo(){
		int st_1=1;
		int st_2=1;
		int st_3=1;
		String oper="+";
		
		removeAll();
		revalidate();
		repaint();
		
		add(cas);
		add(p);
		p.setText(pr + "/" + a);
	    Random randomGenerator = new Random();
	    if (ka==1){
	    	operacija = randomGenerator.nextInt(2);
		    if(operacija == 0){
		    	st_1 = randomGenerator.nextInt(100);
				st_2 = randomGenerator.nextInt(100-st_1);
				st_3 = st_1 + st_2;
				oper = "+";
		    }
		    else if(operacija==1){
		    	st_1 = randomGenerator.nextInt(100);
				st_2 = randomGenerator.nextInt(100-st_1);
				int k = Math.max(st_1,st_2);
				st_2 = Math.min(st_1,st_2);
				st_1 = k;
				st_3 = st_1 - st_2;
				oper = "-";
		    }
	    }
	    else if (ka==2){
			operacija = randomGenerator.nextInt(2);
			if(operacija==0){
		    	st_1 = randomGenerator.nextInt(10)+1;
		    	st_2 = randomGenerator.nextInt(100/st_1);
		    	st_3 = st_1 * st_2;
		    	oper = "*";	    	
		    }
		    else if(operacija==1){
		    	st_1 = randomGenerator.nextInt(10)+1;
		    	st_2 = randomGenerator.nextInt(100/st_1)+1;
		    	int k = st_1 * st_2;
		    	st_3 = st_1;
		    	st_1 = k;
		    	oper = "/";
		    }
		}
	    else if (ka==3){
		    operacija = randomGenerator.nextInt(4);
		    if(operacija == 0){
		    	st_1 = randomGenerator.nextInt(100);
				st_2 = randomGenerator.nextInt(100-st_1);
				st_3 = st_1 + st_2;
				oper = "+";
		    }
		    else if(operacija==1){
		    	st_1 = randomGenerator.nextInt(100);
				st_2 = randomGenerator.nextInt(100-st_1);
				int k = Math.max(st_1,st_2);
				st_2 = Math.min(st_1,st_2);
				st_1 = k;
				st_3 = st_1 - st_2;
				oper = "-";
		    }
		    else if(operacija==2){
		    	st_1 = randomGenerator.nextInt(10)+1;
		    	st_2 = randomGenerator.nextInt(100/st_1);
		    	st_3 = st_1 * st_2;
		    	oper = "*";	    	
		    }
		    else if(operacija==3){
		    	st_1 = randomGenerator.nextInt(10)+1;
		    	st_2 = randomGenerator.nextInt(100/st_1)+1;
		    	int k = st_1 * st_2;
		    	st_3 = st_1;
		    	st_1 = k;
		    	oper = "/";
		    }
	    }
	    
		JLabel vprasanje = new JLabel("Koliko je " + Integer.toString(st_1) + oper + Integer.toString(st_2) + "?");
		vprasanje.setBounds(175, 118, 169, 14);
		add(vprasanje);
		odgovor = new JTextField();
		odgovor.setBounds(103, 143, 239, 23);
		add(odgovor);
		odgovor.requestFocusInWindow();
		JButton gumb = new JButton("Odgovori");
		gumb.setBounds(175, 197, 107, 23);
		add(gumb);
		int odg = st_3;
		gumb.addActionListener(new ActionListener() {					
			@Override
			public void actionPerformed(ActionEvent e) {
				rr = odgovor.getText();				
				if(rr.equals(Integer.toString(odg))){
					++stevec_resenih_nalog;
				}
				removeAll();
				revalidate();
				repaint();
				if(stevec<= a-2){
					++pr;
					++stevec;
					generiraj_nalogo();
				}
				else{
					timer.stop();
					String z = cas.getText();
					int min = Integer.parseInt(z)/60;
					int sec = Integer.parseInt(z) - min*60;
					
					JLabel kuku = new JLabel("", SwingConstants.CENTER);
					if(min>=1){kuku.setText("<html>" + textField.getText() + ", v " + min + " min " + sec + " sec si pravilno rešil/a " + Integer.toString(stevec_resenih_nalog) + " od " + a + " nalog.<br>Dosegel/la si oceno" + " " + Integer.toString(ocena(stevec_resenih_nalog,a)) + ".</html>");}
					else{kuku.setText("<html>" + textField.getText() + ", v " + sec + " sec si pravilno rešil/a " + Integer.toString(stevec_resenih_nalog) + " od " + a +" nalog.<br>Dosegel/la si oceno" + " " + Integer.toString(ocena(stevec_resenih_nalog,a)) + ".</html>");}
					kuku.setBounds(10, 118, 469, 100);
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
