package com.phlacheux.figures;


//package shapes;

import java.io.*;
import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.geom.*;


public class Ellipse extends AbstractFigure{
	// 
	public float d1;
	public float d2;


	public Ellipse(boolean bool){
		super(bool);
		d1=10;
		d2=5;
	}

	public Ellipse(float x, float y, boolean s){
		super(x,y,s);
		d1=30;
		d2=30;
	}


	public Ellipse(float d, float dd, float x, float y, boolean s){
		super(x,y,s);
		d1=d;
		d2=dd;
	}

	protected float aire(){
		return ((float)Math.PI)*d1/2*d2/2;
	}


	protected float perimetre(){
		return  2*((float)Math.PI)*(float)Math.sqrt(0.5*((float)Math.pow(d2,2)+(float)Math.pow(d1,2)));    
	}


	


	protected void print(){
		System.out.println("Ellipse : \n" +"Diametre 1 = "+d1 + "\nDiametre 2 = " +d2 +"\n" + toString());
	}

	public void redimension(float a){
		d1 = a;
		d2 = a;
	}   


	public void redimension2(float a, float b){
		d1 = a;
		d2 = b;
	}   


	public void afficher(Graphics g){
		Ellipse2D ellipse = new Ellipse2D.Double(x,y,d1,d2);       
		g2 = (Graphics2D)g;
		g2.setStroke(bStroke);
		g2.setColor(color);
		if (estRempli== false)
			
			g2.draw(ellipse);
		else{
			g2.fill(ellipse);
			g2.setColor(strokeColor);
			g2.draw(ellipse);
		}

	}
	public void modifier(int x1,int y1,int x2,int y2){
		if (x2<x1)
			x=x2;

		if (y2<y1)
			y=y2;

		redimension2(Math.abs(x2-x1),Math.abs(y2-y1));
	}


	public boolean contient (int a, int b){    
		float c=x+d1/2;
		float d=y+d2/2;

		if ((Math.pow(d2/2,2)*Math.pow(c-a,2)+Math.pow(d1/2,2)*Math.pow(d-b,2))<(Math.pow(d2/2,2)*Math.pow(d1/2,2)))

			return true;
		else
			return false;
	}  


	public String toString(){
		String s = " Ellipse\n"+ " Aire = "+ aire() + "\n Perimetre = "+ perimetre()+"\n"+super.toString();
		return s;
	}
	
	
}

