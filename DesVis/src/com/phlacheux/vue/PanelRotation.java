package com.phlacheux.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelRotation extends JPanel{
	
	private JDialog dialog;
	private boolean sendData;
	private InfoRotation iRot = new InfoRotation();
	private JLabel degreLabel, directionLabel ;
	private JTextField degreText, directionText;
	private JRadioButton sensHoraire;
	private JRadioButton antiHoraire;
	
	public PanelRotation(final JDialog dialog){
		this.dialog = dialog;
		JPanel panDegre = new JPanel();
		panDegre.setBackground(Color.white);
		panDegre.setPreferredSize(new Dimension(235,80));

		degreText = new JTextField();
		degreText.setPreferredSize(new Dimension(50,25));

		degreLabel = new JLabel("Degré :");

		panDegre.setBorder(BorderFactory.createTitledBorder("Degré"));

		panDegre.add(degreLabel);
		panDegre.add(degreText);

		//Direction

		JPanel panDirection = new JPanel();
		panDirection.setBackground(Color.white);
		panDirection.setPreferredSize(new Dimension(235,80));

		ButtonGroup bg = new ButtonGroup();
		sensHoraire = new JRadioButton("Sens horaire");
		antiHoraire = new JRadioButton("Anti horaire");
		
		bg.add(antiHoraire);
		bg.add(sensHoraire);

		panDirection.setBorder(BorderFactory.createTitledBorder("Direction"));

		panDirection.add(sensHoraire);
		panDirection.add(antiHoraire);
		

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panDirection);
		content.add(panDegre);	

		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");

		okBouton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane jOp = new JOptionPane();
				iRot = new InfoRotation(Integer.parseInt(degreText.getText()),getDirection());
				jOp.showMessageDialog(null,iRot.toString(),"Information rotation",JOptionPane.INFORMATION_MESSAGE);
				dialog.setVisible(false);
			}
			
			public String getDirection(){
				return (sensHoraire.isSelected()) ? sensHoraire.getText() :
					(antiHoraire.isSelected()) ? antiHoraire.getText() : null;
					
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

		control.add(cancelBouton);
		control.add(okBouton);

		this.add(content,BorderLayout.CENTER);
		this.add(control,BorderLayout.SOUTH);
	}
	
//	public InfoTranslation showInfo(){
//		this.sendData = false;
//		this.setVisible(true);
//		
//		return this.iTrans;
//	}
}




