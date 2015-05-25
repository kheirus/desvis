package com.phlacheux.vue;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class ChoixTransformations extends JPanel{

	private JPanel panel;
	
	private JButton rotation;
	private JComboBox<String> modifEpaissTrait;
	private JButton modifCouleurTrait;
	private JButton modifCouleur;
	private JRadioButton supprimer;
	private JRadioButton deplacement;
	private JRadioButton dessiner;
	private JRadioButton redimensionner;
	private String [] trait ={"fin","moyen","large"};
	private ButtonGroup bgTransf;
	private BoxLayout bl;
	private JToolBar tb;
	
	public ChoixTransformations (JPanel panel){
		this.panel=panel;
		bl = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setBackground(new Color(38, 97, 156));
		bgTransf = new ButtonGroup();
		Box panneauTransf = Box.createVerticalBox();
		Box c = Box.createVerticalBox();
		
		tb = new JToolBar("Transfo",SwingConstants.HORIZONTAL);
		tb.setBackground(new Color(90, 94, 107));
		
		ImageIcon iconRedimens = createImageIcon("image_resize.png", "Stop");
		ImageIcon iconSupprimer = createImageIcon("deletered.png", "Supprimer");
		ImageIcon iconDeplacer = createImageIcon("move.png",  "Move");
		ImageIcon iconPen = createImageIcon("libre.png",  "Draw");
		//rotation = new JButton("Tourner");
		//modifCouleur = new JButton("Couleur");
		modifEpaissTrait = new JComboBox<String>(trait);
		modifCouleurTrait = new JButton("Couleur");
		
		supprimer = new JRadioButton(iconSupprimer);
		supprimer.setToolTipText("Supprimer");
		supprimer.setBorderPainted(true);
		
		
		deplacement = new JRadioButton(iconDeplacer);
		deplacement.setToolTipText("Deplacer");
		deplacement.setBorderPainted(true);
		dessiner = new JRadioButton(iconPen,true);
		dessiner.setToolTipText("Dessiner");
		dessiner.setBorderPainted(true);
		redimensionner = new JRadioButton(iconRedimens);
		redimensionner.setToolTipText("Redimensionner");
		redimensionner.setBorderPainted(true);
		//redimensionner.setDisabledIcon(icon);
		
		
		//bgTransf.add(rotation);
		//bgTransf.add(modifCouleur);
		//bgTransf.add(modifCouleurTrait);
		bgTransf.add(supprimer);
		bgTransf.add(deplacement);
		bgTransf.add(dessiner);
		bgTransf.add(redimensionner);
		//panneauTransf.add(rotation);
		//panneauTransf.add(modifCouleurTrait);
		tb.add(supprimer);
		tb.add(deplacement);
		tb.add(redimensionner);
		tb.add(dessiner);
		
//		this.setBorder(
//				BorderFactory.createTitledBorder(
//						BorderFactory.createEtchedBorder(
//								EtchedBorder.RAISED, tb.getBackground()
//								, tb.getForeground()), "Transformations"));
		
		
		
		
		
		tb.setFloatable(false);
		tb.setRollover(false);
		
		
		
		this.add(tb);
		//this.add(panneauTransf);
		
		this.setLayout(bl);
		
		
		

		
		
		
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

	public JRadioButton getRedimensionner() {
		return redimensionner;
	}

	public void setRedimensionner(JRadioButton redimensionner) {
		this.redimensionner = redimensionner;
	}

	public JRadioButton getDessiner() {
		return dessiner;
	}

	public void setDessiner(JRadioButton dessiner) {
		this.dessiner = dessiner;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	

	public JButton getRotation() {
		return rotation;
	}

	public void setRotation(JButton rotation) {
		this.rotation = rotation;
	}

	public JComboBox<String> getModifEpaissTrait() {
		return modifEpaissTrait;
	}

	public void setModifEpaissTrait(JComboBox<String> modifEpaissTrait) {
		this.modifEpaissTrait = modifEpaissTrait;
	}

	public JButton getModifCouleurTrait() {
		return modifCouleurTrait;
	}

	public void setModifCouleurTrait(JButton modifCouleurTrait) {
		this.modifCouleurTrait = modifCouleurTrait;
	}

	public JButton getModifCouleur() {
		return modifCouleur;
	}

	public void setModifCouleur(JButton modifCouleur) {
		this.modifCouleur = modifCouleur;
	}

	public String[] getTrait() {
		return trait;
	}

	public void setTrait(String[] trait) {
		this.trait = trait;
	}

	public ButtonGroup getBgTransf() {
		return bgTransf;
	}

	public void setBgTransf(ButtonGroup bgTransf) {
		this.bgTransf = bgTransf;
	}
	public JRadioButton getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(JRadioButton deplacement) {
		this.deplacement = deplacement;
	}

	public JRadioButton getSupprimer() {
		return supprimer;
	}

	public void setSupprimer(JRadioButton supprimer) {
		this.supprimer = supprimer;
	}
	
}
