package com.phlacheux.vue;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.print.DocFlavor.URL;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.Segment;



public class ChoixFigure extends JPanel {

	private BoxLayout bl;

	// Geometrics objects
	private JRadioButton segment;
	private JRadioButton triangle;
	private JRadioButton cercle;
	private JRadioButton ellipse;
	private JRadioButton rectangle;
	private JRadioButton carre;
	private JRadioButton libre;
	private JRadioButton hexagone;
	private JRadioButton losange;
	private ButtonGroup bgFigure;
	private JCheckBox rempli;
	private JPanel panel;
	private Graphics g;
	private BufferedImage bi;
	private JToolBar tb;
	private JButton rotate;
	
	


	



	public ChoixFigure(JPanel panel){
		//setPreferredSize(new Dimension(500,500));
		this.panel=panel;

		bl = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setBackground(new Color(38, 97, 156));
		
		   
		ImageIcon iconSeg = createImageIcon("segment.png",  "Segment");
		ImageIcon iconCercle = createImageIcon("cercle.png",  "Cercle");
		ImageIcon iconTriangle = createImageIcon("triangle.png",  "Triangle");
		ImageIcon iconEllipse = createImageIcon("ellipse.png",  "Ellipse");
		ImageIcon iconRectangle = createImageIcon("rectangle.png",  "Rectangle");
		ImageIcon iconCarre = createImageIcon("carre.png",  "Carre");
		ImageIcon iconHexagone = createImageIcon("hexagone.png",  "Hexagone");
		ImageIcon iconLosange = createImageIcon("losange.png",  "Losane");
		ImageIcon iconLibre = createImageIcon("pen.png",  "Libre");
		//this.add(rechercher);  

		segment = new JRadioButton(iconSeg);
		segment.setToolTipText("Segment");
		segment.setBorderPainted(true);
		
		cercle = new JRadioButton(iconCercle);
		cercle.setToolTipText("Cercle");
		cercle.setBorderPainted(true);
		
		triangle = new JRadioButton(iconTriangle);
		triangle.setToolTipText("Triangle");
		triangle.setBorderPainted(true);
		
		ellipse = new JRadioButton(iconEllipse);
		ellipse.setToolTipText("Ellipse");
		ellipse.setBorderPainted(true);
		
		rectangle = new JRadioButton(iconRectangle);
		rectangle.setToolTipText("Rectangle");
		rectangle.setBorderPainted(true);
		
		carre = new JRadioButton(iconCarre);
		carre.setToolTipText("Carre");
		carre.setBorderPainted(true);
		
		hexagone = new JRadioButton(iconHexagone);
		hexagone.setToolTipText("Hexagone");
		hexagone.setBorderPainted(true);
		
		losange = new JRadioButton(iconLosange);
		losange.setToolTipText("Losange");
		losange.setBorderPainted(true);
		
		libre = new JRadioButton(iconLibre,true);
		libre.setToolTipText("Libre");
		libre.setBorderPainted(true);
		
		rempli = new JCheckBox("Remplissage");
		
		tb = new JToolBar("Figures",SwingConstants.VERTICAL);
		bgFigure = new ButtonGroup();
		rotate = new JButton("Rotate");
		
		
		tb.setBackground(new Color(90, 94, 107));
		
		
		//Box panneauFigure = Box.createVerticalBox();

		
		bgFigure.add(segment);
		bgFigure.add(cercle);
		bgFigure.add(triangle);
		bgFigure.add(ellipse);
		bgFigure.add(rectangle);
		bgFigure.add(carre);
		bgFigure.add(hexagone);
		bgFigure.add(losange);
		bgFigure.add(libre);
		
		
		
		
		
		tb.add(segment);
		tb.add(cercle);
		tb.add(triangle);
		tb.add(ellipse);
		tb.add(rectangle);
		tb.add(carre);
		tb.add(hexagone);
		tb.add(losange);
		tb.add(libre);
		tb.addSeparator();
		tb.add(rempli);
		
		
		
		
//		this.setBorder(
//				BorderFactory.createTitledBorder(
//						BorderFactory.createEtchedBorder(
//								EtchedBorder.RAISED, tb.getBackground()
//								, tb.getForeground()), "Frigures"));
		
		
		
		tb.setFloatable(false);
		tb.setRollover(false);
		
		
		
		this.add(tb);
		//this.add(rempli);
		this.setLayout(bl);


		/* Panel de tranformation **/
				

	}




	private static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = ChoixFigure.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}	
	//Getters and setters	

	public BoxLayout getBl() {
		return bl;
	}

	public void setBl(BoxLayout bl) {
		this.bl = bl;
	}

	public JRadioButton getSegment() {
		return segment;
	}

	public void setSegment(JRadioButton segment) {
		this.segment = segment;
	}

	public JRadioButton getTriangle() {
		return triangle;
	}

	public void setTriangle(JRadioButton triangle) {
		this.triangle = triangle;
	}

	public JRadioButton getCercle() {
		return cercle;
	}

	public void setCercle(JRadioButton cercle) {
		this.cercle = cercle;
	}


	public JRadioButton getEllipse() {
		return ellipse;
	}


	public void setEllipse(JRadioButton ellipse) {
		this.ellipse = ellipse;
	}


	public JRadioButton getRectangle() {
		return rectangle;
	}

	public void setRectangle(JRadioButton rectangle) {
		this.rectangle = rectangle;
	}



	public JRadioButton getCarre() {
		return carre;
	}

	public void setCarre(JRadioButton carre) {
		this.carre = carre;
	}



	public JCheckBox getRempli() {
		return rempli;
	}

	public void setRempli(JCheckBox rempli) {
		this.rempli = rempli;
	}

	public JRadioButton getLibre() {
		return libre;
	}


	public void setLibre(JRadioButton libre) {
		this.libre = libre;
	}




	public JRadioButton getHexagone() {
		return hexagone;
	}




	public void setHexagone(JRadioButton hexagone) {
		this.hexagone = hexagone;
	}




	public JRadioButton getLosange() {
		return losange;
	}




	public void setLosange(JRadioButton losange) {
		this.losange = losange;
	}
	

	
	


}
