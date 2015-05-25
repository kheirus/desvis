package com.phlacheux.figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Cercle extends Ellipse
{

	public Cercle(boolean bool)
	{
		// initialise les variables d'instance
		super(10,10,bool);
	}

	public Cercle(float x, float y, boolean bool)
	{
		// initialise les variables d'instance
		super(10,10,x,y,bool);
	}


	public Cercle(float R, float x, float y,boolean bool)
	{

		super(R,R,x,y,bool);
	}


	public void redimension2(float a, float b) 
	{
		if (a==b)
			super.redimension2(a,b);
		else
			;

	}

	public void modifier(int x1,int y1,int x2,int y2)
	{

		/*On redimensionne le Cercle avec les rayons de taille imposé par le déplacement de la souris en utilisant le plus grand déplacement entre x et y*/
		if ((Math.abs(x2-x1))<(Math.abs(y2-y1)))
		{                       
			redimension(Math.abs(y2-y1)+d1/2);
		}

		else 
		{
			redimension(Math.abs(x2-x1)+d1/2);

		}
	}

	public void afficher(Graphics g)
	{
		Ellipse2D ellipse = new Ellipse2D.Double(x-d1/2,y-d2/2,d1,d2);//on créer le Cercle à afficher       
		Graphics2D g2 = (Graphics2D)g;//on converti g en type 2D pour pouvoir créer un cercle sur le type d'une Ellipse2D
		g2.setStroke(bStroke);
		g2.setColor(color);//on va utiliser la couleur du cercle pour la dessiner
		if (estRempli== false)
			g2.draw(ellipse);//on crée un cercle vide
		else{
			g2.fill(ellipse);//on crée un cercle plein
			g2.setColor(strokeColor);
			g2.draw(ellipse);

		}

	}


	public boolean contient (int a, int b)
	{      
		//System.out.println(x+","+y);
		if (d2/2>=Math.sqrt(Math.pow(a-x,2)+Math.pow(b-y,2)))
			return true;
		else
			return false;
	}  

	/*
    protected void print()
        {   
            System.out.println("Cercle :\n" + "Diametre = "+d2+"\n"+ toString());
        }
	 */

	public String toString()
	{
		String s = " Cercle\n"+super.toString()+"\n";
		return s;
	}        


}

