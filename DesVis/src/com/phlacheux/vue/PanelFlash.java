package com.phlacheux.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFlash extends JPanel{
	
	private JDialog dialog;
	private InfoFlash iFlash = new InfoFlash();
	private JLabel labelColor, labelVitesse;
	private JComboBox comboColor;
	private JTextField textVitesse;
	public PanelFlash(final JDialog dialog){
		this.dialog = dialog;
		
		//Couleur
		JPanel panCouleur = new JPanel();
		panCouleur.setBackground(Color.white);
		panCouleur.setPreferredSize(new Dimension(235,80));
		
		labelColor = new JLabel("Couleur");
		String [] couleur = {"Rouge","Jaune","Vert"};
		comboColor = new JComboBox(couleur);
		
		panCouleur.setBorder(BorderFactory.createTitledBorder("Couleur"));
		
		panCouleur.add(labelColor);
		panCouleur.add(comboColor);
		
		//Vitesse
		
		JPanel panVitesse = new JPanel();
		panVitesse.setBackground(Color.white);
		panVitesse.setPreferredSize(new Dimension(235,80));
		
		labelVitesse = new JLabel("Vitesse");
		textVitesse = new JTextField();
		textVitesse.setPreferredSize(new Dimension(50,25));
		
		panVitesse.setBorder(BorderFactory.createTitledBorder("Vitesse : "));
		
		panVitesse.add(labelVitesse);
		panVitesse.add(textVitesse);
		
		
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panCouleur);
		content.add(panVitesse);
		
		//Control OK + Annuler
		JPanel control = new JPanel();
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane jOp = new JOptionPane();
				iFlash= new InfoFlash((String)comboColor.getSelectedItem(),Integer.parseInt(textVitesse.getText()));
				jOp.showMessageDialog(null, iFlash.toString(),
						"Information Flash",JOptionPane.INFORMATION_MESSAGE);
				dialog.setVisible(false);
			}
		});
		
		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog.setVisible(false);
			}
		
		});
		
		control.add(okButton);
		control.add(cancelBouton);
		
		this.add(content,BorderLayout.CENTER);
		this.add(control,BorderLayout.NORTH);
		
	}
	
	

}
