package com.phlacheux.vue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	JMenu fichier;
	JMenuItem enregistrer;
	JMenuItem enregisteSous;
	JMenuItem quitter;
	
	public MenuBar(){createMenuFichier();}
	
	public void createMenuFichier(){
		
		fichier = new JMenu("Fichier");
		enregistrer = new JMenuItem("Enregistrer");
		enregisteSous = new JMenuItem("Enregistrer sous...");
		quitter = new JMenuItem("Quitter");
		
		fichier.add(enregistrer);
		fichier.add(enregisteSous);
		fichier.addSeparator();
		fichier.add(quitter);
		
		this.add(fichier);
		
	}

	public JMenuItem getEnregistrer() {
		return enregistrer;
	}

	public void setEnregistrer(JMenuItem enregistrer) {
		this.enregistrer = enregistrer;
	}

	public JMenuItem getEnregisteSous() {
		return enregisteSous;
	}

	public void setEnregisteSous(JMenuItem enregisteSous) {
		this.enregisteSous = enregisteSous;
	}

	public JMenuItem getQuitter() {
		return quitter;
	}

	public void setQuitter(JMenuItem quitter) {
		this.quitter = quitter;
	}

}
