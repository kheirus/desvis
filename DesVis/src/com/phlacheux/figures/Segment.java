package com.phlacheux.figures;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

public class Segment extends AbstractFigure{
	
	
	Shape shape;
	Point p1;
	Point p2;

	public Segment(Point p1, Point p2){
		super();
		this.p1 = p1;
		this.p2 = p2;

	}


	@Override
	public void afficher(Graphics g){	
		g2 = (Graphics2D)g;
		g2.setStroke(bStroke);
		g2.setColor(color);
		shape = new Line2D.Double(p1,p2);
		g2.draw(shape);
		g2.setStroke(new BasicStroke(1f));
	}

	@Override
	public boolean contient (int a, int b){
		/*
		 * On compare la pente du segment avec celle
		 * du point cliqué et le point de fin du segment puis si le x du point cliqué
		 * est compris entre p2.x  et p1.x on est OK !!!  
		 */
		
		if((p2.x - p1.x)/(p2.y -p1.y)== (a-p1.x)/(b-p1.y)){
			if( a <= p2.x &&  a >= p1.x)
				return true;
		}
		return false;
		
		
	
	}		
}
