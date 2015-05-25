package com.phlacheux.figures;

import java.io.*;
import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;
import java.util.*;




public class Ligne extends AbstractFigure
{
   public Vector<Point> courbe = new Vector<Point>();

   
   int n;//point sélectionné
   
    public Ligne (boolean s)
        {
            super(s);
            x=10;
            y=10;
        }
        
   
     public Ligne(float x, float y, boolean s)
        { 
             super(x,y,s);
             Point p = new Point((int)x,(int)y);
             courbe.addElement(p);
        }

    
    public String toString2(int a,int b)
        {
            return "Position "+a+", "+b;    
        }
        
    
    protected void print()
        {
            System.out.println(toString());
        }
    
    
    public void afficher(Graphics g)
        {
            int x3;
            int y3;
            int x4;
            int y4;
            
            g.setColor(color);//on donne la couleur à utiliser pour dessiner qui correspond à la couleur de la courbe                                 
            
            int tvecteur= courbe.size();//variable interne correspondant au nombre total de points crées
            for(int i=0; i<tvecteur; i++)//parcours de la liste de points
               {  
                   x3=((Point)(courbe.get(i))).x;
                   y3=((Point)(courbe.get(i))).y;
                   if (i!=0)
                    {
                        x4=((Point)(courbe.get(i-1))).x;
                        y4=((Point)(courbe.get(i-1))).y;   
                        g.drawLine(x4,y4,x3,y3);
                    }
                   else
                    g.drawLine(x3,y3,x3,y3);
               }
        }
     
     
    protected float aire()
    {
        return 0;
    }
    
    
    protected float perimetre() 
        {
            return 0;
        }
       
    
    public void modifier(int x1,int y1,int x2,int y2)
        {
            Point p=new Point(x2,y2);
            courbe.addElement(p);                
             /*On redimensionne la ligne avec les longueurs de taille imposé par le déplacement de la souris*/
        }

     /**
     * Définition de la méthode contient, pour savoir si un endroit est contenue dans une courbe
     * @param a : abscisse du pointeur pressé
     * @param b : ordonnée du pointeur pressé 
     */
    public boolean contient (int a, int b)
        {   
            //int i;
            boolean c=false;
            
            Iterator<Point> it =  courbe.iterator();//on utilise un itérateur pour parcourir les points de la courbe
            while(it.hasNext())
                { 
                    Point point = (Point) it.next(); 
                    if ((point.x<=(a+10))&&(point.x>=(a-10))&&(point.y<=(b+10))&&(point.y>=(b-10)))
                        {
                            c=true;
                            break;
                        }
                }
            return c;
        }  
        
     
        public void deplacer(float a, float b, float c, float d, float e, float f)
        {   
            int xdiff;
            int ydiff;

            xdiff=(int)x-(int)a;
            ydiff=(int)y-(int)b;
            
            /*on parcours la courbe et on déplace point par point*/
            for(int i=0;i<courbe.size();i++)
                {
                    Point point1 = (Point)courbe.get(i);    
                    point1.x=point1.x-xdiff;
                    point1.y=point1.y-ydiff;
                }
                    x=a;
                    y=b;
         }

    public boolean isLigne()
        {         
            return true;
        }            

}