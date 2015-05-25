package com.phlacheux.vue;

import java.awt.MenuItem;
import java.awt.image.BufferedImage;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	
	JMenu fichier;
	JMenuItem enregistrer;
	JMenuItem enregistrerSous;
	JMenuItem quitter;
	BufferedImage bi;
	public Menu(BufferedImage bi){
		this.bi = bi;
		createMenuFichier();
	}
	
	public void createMenuFichier(){
		fichier = new JMenu("Fichier");
		ListenerMenuBar listenerMenuBar = new ListenerMenuBar(bi);
		
		//Création des menus items
		enregistrer = new JMenuItem("Enregistrer");
		enregistrerSous = new JMenuItem("Enregistrer sous...");
		quitter = new JMenuItem("Quitter");
		
		//Ajout des menus items dans le JMenu
		fichier.add(enregistrer);
		fichier.add(enregistrerSous);
		fichier.addSeparator();
		fichier.add(quitter);
		
		//Ecouteur Menu Fichier
		quitter.addActionListener(listenerMenuBar);
		enregistrer.addActionListener(listenerMenuBar);
		this.add(fichier);
		
		
		
		
	}
	
	

}
