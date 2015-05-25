package com.phlacheux.figures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import javax.swing.event.ChangeEvent;

public class Triangle extends AbstractFigure{
	int longueur;
	double hauteur;
	
	Shape shape;
	int [] xPoints;
	int [] yPoints;
	

	public Triangle(int x, int y,boolean remplissage){
		super(x,y,remplissage);
		xPoints = new int[3];
		yPoints = new int[3];
		this.longueur = 120;
		this.hauteur = (longueur*(Math.sqrt(3/2)));
		xPoints[0] = x;
		xPoints[1] = x+longueur/2;
		xPoints[2] = x-longueur/2;	
		yPoints[0] = y;
		yPoints[1] = (int)(y+hauteur);
		yPoints[2] = (int)(y+hauteur);
	}


	public void afficher(Graphics g){
		
		g2 = (Graphics2D)g;
		
		//g2 = bufferedImage.createGraphics();
		//g.drawImage(bufferedImage,0,0,null);
		g2.setStroke(bStroke);
		g2.setColor(color);
		shape = new Polygon(xPoints, yPoints,xPoints.length);
		if(this.estRempli == true){
			g2.fill(shape);
			g2.setColor(strokeColor);
			g2.draw(shape);
			
		}
		else{
			g2.draw(shape);
			
		}
		g2.setStroke(new BasicStroke(1f));
	}
	
	
	public boolean contient (int a, int b){
		return shape.contains(a, b);
		
	}
	
	public void setColor(Color c){
		super.setColor(c);
		g2.setColor(c);
	}


	

}
