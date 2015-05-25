package com.phlacheux.figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;

public class Losange extends AbstractFigure{
	
	int largeur;
	int hauteur;
	Shape shape;
	
	int [] xPoints;
	int [] yPoints;
	
	public Losange(int x, int y, boolean remplissage){
		super(x,y,remplissage);
		xPoints = new int[4];
		yPoints = new int[4];
		this.largeur = 120;
		this.hauteur = 180;
		xPoints[0] = x;
		xPoints[1] = largeur/2;
		xPoints[2] = largeur;
		xPoints[3] = largeur/2;
		
		yPoints[0] = y;
		yPoints[1] = 0;
		yPoints[2] = y;
		yPoints[3] = hauteur;
				
		
	}
	
	public void afficher(Graphics g){
		g2 = (Graphics2D) g;
		g2.setStroke(bStroke);
		g2.setColor(color);
		shape = new Polygon(xPoints, yPoints, 4);
		if(this.estRempli == true){
			g2.fillPolygon(xPoints, yPoints, 4);
			g2.setColor(strokeColor);
			g2.draw(shape);
		}else{
			g2.draw(shape);
		}
	}
	
	public boolean contient(int a,int b){
		return shape.contains(a, b);
	}

}
