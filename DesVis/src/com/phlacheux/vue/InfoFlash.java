package com.phlacheux.vue;

public class InfoFlash {

	private String couleur;
	private int vitesse;
	
	public InfoFlash(){}
	
	public InfoFlash(String couleur, int vitesse){
		this.couleur = couleur;
		this.vitesse = vitesse;
	}
	public String toString(){
		String str;
		str = "Couleur : " +this.couleur + "\n" +
		"Vitesse : "+ this.vitesse;
		
		return str;
	}

}
