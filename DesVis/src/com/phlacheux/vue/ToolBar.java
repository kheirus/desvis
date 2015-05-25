package com.phlacheux.vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class ToolBar extends JPanel {
    JFrame frame;
    JButton cercle;
	public ToolBar(JFrame f){
	this.frame=f;
	
	setPreferredSize(new Dimension(140, 140));
	Container c = new Container();
	c=f.getContentPane();
	c.setLayout(new BorderLayout());

	JToolBar tb = new JToolBar(SwingConstants.VERTICAL);
	tb.setFloatable(true);
	tb.setRollover(true);
	
	
	    cercle = new JButton("cercle");
	    cercle.setToolTipText("creer un cercle "+cercle.getText());
	    tb.add(cercle);
	tb.setVisible(true);
	

	

	
	

	
    
    
    /*
    public static void main(String [] args) {
	
	try {
	    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	} catch(Exception e) {
	    e.printStackTrace();
	}
	SwingUtilities.invokeLater(new ToolBarExample());
    }
*/
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JButton getCercle() {
		return cercle;
	}
	public void setCercle(JButton cercle) {
		this.cercle = cercle;
	}
    }
