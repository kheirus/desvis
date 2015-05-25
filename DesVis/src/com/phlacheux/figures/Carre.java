package com.phlacheux.figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;

public class Carre extends Rectangle
{    
    public Carre(boolean bool)
        {
            super(10,10,0,0,bool);
        }
    
     
    public Carre(float x, float y,boolean bool)
        {
            super(10,10,x,y,bool);
        }
    
      
    public Carre(float l, float x, float y,boolean bool)
        {
            super(l,l,x,y,bool);    
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
                
            if (Math.abs(x2-x1)<Math.abs(y2-y1))
                {  
                    redimension(Math.abs(y2-y1)+largeur/2);
                }
            else 
                {
                    redimension(Math.abs(x2-x1)+longueur/2);          
                }
         }   
    public void afficher(Graphics g)
        {
            Rectangle2D.Float rect = new Rectangle2D.Float(x-longueur/2,y-largeur/2,longueur,largeur);//on crée un Rectangle2D
            Graphics2D g2 = (Graphics2D)g;//on cast g en 2D pour pouvoir faire des carré sur le type de Rectangle2D
            g2.setStroke(bStroke);
            g.setColor(color);//on donne la couleur à utiliser pour dessiner qui correspond à la couleur du Carré
            if(estRempli == false)
                  g2.draw(rect);//on dessine un rectangle vide
            else
            	
                  g2.fill(rect);//on dessine un rectangle plein
            	  g2.setColor(strokeColor);
            	  g2.draw(rect);
        }
    
    public boolean contient (int a, int b)
        {         
            if (((a>x-longueur/2)&&(a<(x+longueur/2)))&&((b>y-largeur/2)&&(b<(y+largeur/2))))
                return true;
            else
                return false;
        }  

    public void rotation (Graphics g){
    	
    	//at = g2.getTransform();
    	//at.setToTranslation(0,0);
    	//System.out.println("Y ="+at.getScaleX()+" "+"X = "+at.getShearX());
    	at= new AffineTransform();
    	at.rotate(Math.toRadians(45),x,y);
    	//Rectangle2D.Float rectRot = new Rectangle2D.Float(x-longueur/2,y-largeur/2,longueur,largeur);    	
    	
    	g2 = (Graphics2D)g;
    	g2.setTransform(at);
    	//g2.draw(at.createTransformedShape(rectRot));
    	//g2.getTransform();
    	//g2.dispose();
    	
    	afficher(g2);
    	
    	
    }
    
    
    /*
    protected void print(JLabel label)
    {
        label
    
    }    
    */
    public String toString()
        {
            return " Carré\n"+ super.toString();
        }
    
    
}

