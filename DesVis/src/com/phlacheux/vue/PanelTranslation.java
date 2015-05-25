package com.phlacheux.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTranslation extends JPanel{
	
	private JDialog dialog;
	private InfoTranslation iTrans = new InfoTranslation();
	private boolean sendData;
	private JTextField textXDepart, textYDepart, textXArrivee, textYArrivee;
	private JLabel labelXDepart, labelYDepart, labelXArrivee, labelYArrivee;
	
	
	public PanelTranslation(final JDialog dialog){
		this.dialog = dialog;
	
		
		//Point Depart
		
		JPanel panPointDepart = new JPanel();
		panPointDepart.setBackground(Color.white);
		panPointDepart.setPreferredSize(new Dimension(235,80));
		
		labelXDepart = new JLabel("X : ");
		labelYDepart = new JLabel("Y : ");
		
		textXDepart = new JTextField();
		textXDepart.setPreferredSize(new Dimension(50,25));
		
		textYDepart = new JTextField();
		textYDepart.setPreferredSize(new Dimension(50,25));
		
		
		panPointDepart.setBorder(BorderFactory.createTitledBorder("Point Départ"));
		
		panPointDepart.add(labelXDepart);
		panPointDepart.add(textXDepart);
		
		panPointDepart.add(labelYDepart);
		panPointDepart.add(textYDepart);
		
		//Point arrivee
		
		JPanel panPointArrivee = new JPanel();
		panPointArrivee.setBackground(Color.white);
		panPointArrivee.setPreferredSize(new Dimension(235,80));
		
		labelXArrivee = new JLabel("X : ");
		labelYArrivee = new JLabel("Y : ");
		
		textXArrivee = new JTextField();
		textXArrivee.setPreferredSize(new Dimension(50,25));
		
		textYArrivee = new JTextField();
		textYArrivee.setPreferredSize(new Dimension(50,25));
		
		
		panPointArrivee.setBorder(BorderFactory.createTitledBorder("Point Arrivée"));
		
		panPointArrivee.add(labelXArrivee);
		panPointArrivee.add(textXArrivee);
		
		panPointArrivee.add(labelYArrivee);
		panPointArrivee.add(textYArrivee);
		
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panPointDepart);
		content.add(panPointArrivee);
		
		
		//Panel Controle
		
		JPanel control = new JPanel();
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane jOp = new JOptionPane();
				iTrans = new InfoTranslation(Integer.parseInt(textXDepart.getText()),
						Integer.parseInt(textXDepart.getText()),
						Integer.parseInt(textXArrivee.getText()), 
						Integer.parseInt(textYArrivee.getText()));
				jOp.showMessageDialog(null, iTrans.toString(),
						"Information translation",JOptionPane.INFORMATION_MESSAGE);
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
