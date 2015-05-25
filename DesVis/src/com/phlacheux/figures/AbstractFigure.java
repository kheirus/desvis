package com.phlacheux.figures;



import java.io.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


public abstract class AbstractFigure{

	public float x;
	public float y;
	public boolean estRempli;
	public Color color;
	public AffineTransform at;
	public Graphics2D g2;
	public BasicStroke bStroke;
	public Color strokeColor;
	public BufferedImage bufferedImage;

	
	
	public AbstractFigure(){this.bStroke = new BasicStroke(1f);
	//this.bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
	}
	
	
	public AbstractFigure(boolean bool){
		x=0;
		y=0;
		color=Color.lightGray;
		estRempli=bool;
		strokeColor = Color.lightGray;
		//this.bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
	}
	
	
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}


	public void setBufferedImage(BufferedImage bufferedImage) {
		///this.bufferedImage = bufferedImage;
	}


	public AbstractFigure(float x, float y, boolean bool){
		this.x=x;
		this.y=y;
		this.color=Color.GRAY;
		this.estRempli=bool;
		this.bStroke = new BasicStroke(1f);
		//this.bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
	}

	public void setColor(Color c){
		color=c;
	}  

	public void  deplacer(float a, float b, float c, float d, float e, float f){
		x=c+(e-a);
		y=d+(f-b);
	}

	protected float aire()
	{
		return 0;
	}

	protected float perimetre() 
	{
		return 0;
	}

	
	public void redimension(float a)
	{
	}

	
	public void redimension2(float a, float b)throws Exception
	{
	}
	
	public void modifier(int x1, int y1, int x2, int y2)
	{
	}

	public void afficher(Graphics g)
	{
		
	}

	
	public boolean contient (int a, int b)
	{         
		return false;
	}     

	
	public boolean isLigne()
	{         
		return false;
	}            
	
	public boolean isRectangle()
	{         
		return false;
	}     
	
	public void setStrokeColor(Color c){
		strokeColor = c;
	}
	public void setBacisStroke(float f){
		this.bStroke = new BasicStroke(f);
	}
	
//	public AbstractFigure rotation (Graphics g){
//		return this;
//    	
//    }
	
	public void saveTrans (Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		AffineTransform saveXform = g2.getTransform();
		g2.setTransform(saveXform);
		afficher(g2);
	}
	
	
	public String toString()
	{
		String s = " Coordonée (x,y) :\n ("+x+", "+y+")";
		return s;
  
    }

	public Color getColor() {
		
		return color;
	}


 	public void rotation(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	

}

