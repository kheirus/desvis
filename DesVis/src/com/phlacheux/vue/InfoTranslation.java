package com.phlacheux.vue;

public class InfoTranslation {
	
	private int XPointDepart, YPointDepart;
	private int XPointArrivee, YPointArrivee;
	
	public InfoTranslation(){}
	
	public InfoTranslation(int XPointDepart, int YPointDepart, int XPointArrivee, int YPointArrivee){
		this.XPointDepart = XPointDepart;
		this.YPointDepart = YPointDepart;
		
		this.XPointArrivee = XPointArrivee;
		this.YPointArrivee = YPointArrivee;
		
	}
	
	public String toString(){
		String str;
		str = "Point Depart : \n  X : " +
		this.XPointDepart + "\n" + "Y : " + this.YPointDepart + "\n" +
		"Point Arrivee :  \n X : "+ this.XPointArrivee + "\n" +
		"Y : "+ this.YPointArrivee;
		
		return str;
				
	}

}
