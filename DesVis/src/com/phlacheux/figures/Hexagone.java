package com.phlacheux.figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Hexagone extends AbstractFigure {

	int decalage;
	int taille;
	int px1,px2,px3,px4,px5,px6;
	int py1,py2,py3,py4,py5,py6;
	Polygon p;

	public Hexagone(boolean bool)
	{
		super(bool);
		decalage = 10;
		taille = 20;
	}

	public Hexagone(float x, float y, boolean bool)
	{ 
		super(x,y,bool);
		decalage = 10;
		taille = 20;
	}

	public Hexagone(float nd, float nt, float x, float y,boolean bool)
	{
		super(x, y, bool);
		decalage = (int)nd;
		taille =(int)nt;
	}


	public void afficher(Graphics g)
	{
		px1=(int)x;
		px2=px1+decalage;
		px3=px2+taille;
		px4=px3+decalage;
		px5=px4-decalage;
		px6=px5-taille;
		
		

		py1=(int)y;
		py2=py1-taille;
		py3=py2;
		py4=py3+taille;
		py5=py4+taille;
		py6=py5;
		int xp[] ={px1,px2,px3,px4,px5,px6};
		int xy[] = {py1,py2,py3,py4,py5,py6};

		p = new Polygon(xp,xy,xp.length);

		g2 = (Graphics2D)g;
		g2.setStroke(bStroke);
		g.setColor(color);
		if(estRempli == false)
			g2.drawPolygon(p);
		else{
			g2.fillPolygon(p);
			g2.setColor(strokeColor);
			g2.drawPolygon(p);
		}
	}

	public void redimension2(float nd, float nt) //throws Exception
	{	
		
		decalage=(int)nd;
		taille=(int)nt;
	}


	public void redimension(float a)
	{
		decalage=(int)a;
		taille=(int)a;
	}


	public void modifier(int x1,int y1,int x2,int y2)
	{

		if (x2<x1)
			x=x2;

		if (y2<y1)
			y=y2;

		/*On redimensionne le Rectangle avec les longueurs de taille imposé par le déplacement de la souris*/            
		redimension2(Math.abs(x2-x1),Math.abs(y2-y1));

	}
	
	public boolean contient(int a,int b){
		return p.contains(a, b);
	}


}
