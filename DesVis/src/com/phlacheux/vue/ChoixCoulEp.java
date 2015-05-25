package com.phlacheux.vue;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ChoixCoulEp extends JPanel{
	
	private JButton buttonCouleur;
	private JButton buttonStrokeCouleur;
	private JSlider epaisseurTrait;
	
	private JPanel panCouleur;
	//float tailleTrait;
	
	
	
	public ChoixCoulEp(){
		
		ImageIcon iconCoul = createImageIcon("color.png", "Stop");
		
		this.setBackground(new Color(90, 94, 107));
		buttonCouleur = new JButton(iconCoul);
		epaisseurTrait = new JSlider(0,30,10);
		buttonStrokeCouleur = new JButton("Stroke Couleur");
		
		epaisseurTrait.setMajorTickSpacing(5);
		epaisseurTrait.setMinorTickSpacing(1);
		epaisseurTrait.setPaintLabels(true);
		epaisseurTrait.setPaintTicks(true);
		
		
		//panCouleur = new JPanel();
		//panCouleur.setSize(50,50);
		//panelForButton = new JPanel();
		
		
		this.add(buttonCouleur);
		//this.add(panCouleur);
		this.add(epaisseurTrait);
		this.add(buttonStrokeCouleur);
		
	}
	
	public JButton getButtonCouleur() {
		return buttonCouleur;
	}

	public void setButtonCouleur(JButton buttonCouleur) {
		this.buttonCouleur = buttonCouleur;
	}

	public JButton getButtonStrokeCouleur() {
		return buttonStrokeCouleur;
	}

	public void setButtonStrokeCouleur(JButton buttonStrokeCouleur) {
		this.buttonStrokeCouleur = buttonStrokeCouleur;
	}

	public JSlider getEpaisseurTrait() {
		return epaisseurTrait;
	}

	public void setEpaisseurTrait(JSlider epaisseurTrait) {
		this.epaisseurTrait = epaisseurTrait;
	}

	public JPanel getPanCouleur() {
		return panCouleur;
	}

	public void setPanCouleur(JPanel panCouleur) {
		this.panCouleur = panCouleur;
	}

	

	private static ImageIcon createImageIcon(String path , String description) {
		java.net.URL imgURL = Fenetre.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
