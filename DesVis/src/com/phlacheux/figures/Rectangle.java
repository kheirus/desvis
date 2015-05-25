package com.phlacheux.figures;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Rectangle extends AbstractFigure
{
    
    public float longueur;
    public float largeur;
    Shape shape;
   
    public Rectangle(boolean bool)
        {
            super(bool);
            longueur = 10;
            largeur = 20;
        }
    
     public Rectangle(float x, float y, boolean bool)
        { 
            super(x,y,bool);
            longueur = 20;
            largeur = 10;
        }

     public Rectangle(float lo, float la, float x, float y,boolean bool)
        {
            super(x, y, bool);
            longueur = lo;
            largeur =la;
        }
 
 
    
    public void afficher(Graphics g)
        {
    		
            g2 = (Graphics2D)g;
            //g2 = bufferedImage.createGraphics();
            //g.drawImage(bufferedImage,0,0,null);
            g2.setStroke(bStroke);
            g2.setColor(color);
            shape = new Rectangle2D.Float(x,y,longueur,largeur);//on crée un Rectangle2D
            if(estRempli == false)
                  g2.draw(shape);
            else{
                  g2.fill(shape);
                  g2.setColor(strokeColor);
                  g2.draw(shape);
            
            }
        //    g2.setStroke(new BasicStroke(1f));
          
        }
     
    
    public void selection (Rectangle r)
    {
    	
    	
    }
    
    protected float aire()
    {
        return longueur*largeur;
    }
    
    
    protected float perimetre() 
        {
            return 2*(longueur+largeur);
        }
        
    
    public void redimension2(float nlo, float nla) //throws Exception
        {
            longueur=nlo;
            largeur=nla;
        }
   
     
     public void redimension(float a)
        {
            longueur=a;
            largeur=a;
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

    public boolean contient (int a, int b)
        {         
            if (((a>x)&&(a<(x+longueur)))&&((b>y)&&(b<(y+largeur))))
                return true;
            else
                return false;
        }
    /*
    protected void print()
    {
        System.out.println("rectangle \n"+"largeur= "+largeur+"\n"+"longueur= "+longueur+"\n"+ toString());
    }
*/
    public boolean isRectangle()
    {
    	return true;
    	
    }
    
    
    public String toString()
    {
    	String s = " Rectangle\n"+" Largeur= "+largeur+"\n Longueur= "+longueur+"\n";
        return s+ " Aire= "+aire()+"\n"+" Perimetre= "+perimetre()+"\n"+super.toString();    
    }

}