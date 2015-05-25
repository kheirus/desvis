package com.phlacheux.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class ListenerMenuBar implements ActionListener{
	
	BufferedImage bi;
	String source;
	JFileChooser save;
	int returnVal;
	
	public ListenerMenuBar(BufferedImage bi){
		this.bi = bi;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		source = e.getActionCommand();
		if(source.equals("Quitter")){
			System.out.println("J'ai appuyé sur quitté");
			System.exit(1);
		}else if(source.equals("Enregistrer")){
			System.out.println("J'ai appuyé sur enregistrer");
			save = new JFileChooser();
			returnVal = save.showSaveDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				
				try{
					ImageIO.write(bi,"png" ,save.getSelectedFile());
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		System.out.println("MEMEMEM");
	}
	

}
