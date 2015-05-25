package com.phlacheux.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class DialogAnimation extends JDialog{
	
	
	
	public DialogAnimation(JFrame frame,String title, boolean modal){
		super(frame,title,modal);
		this.setSize(600,200);
		this.setLocationRelativeTo(null);
		//Pour qu'on ne puisse pas redimensionner la fenetre
		this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.add("Rotation",new PanelRotation(this));
		tabbedPane.add("Translation", new PanelTranslation(this));
		tabbedPane.add("Flash",new PanelFlash(this));
		
		this.add(tabbedPane);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		setVisible(true);
		
	}
	
	
	
	
		
	
}
