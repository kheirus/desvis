package com.phlacheux.vue;

public class InfoRotation{
	
	private int degre;
	private String direction;
	
	public InfoRotation(){}
	public InfoRotation(int degre, String direction){
		this.degre = degre;
		this.direction = direction;
	}
	
	public String toString(){
		String str;
		if(this.degre != 0 && this.direction != null){
			str = "Degre : " +this.degre + "\n";
			str +="Direction : " + this.direction + "\n";
		}else{
			str = "Aucune information";
		}
		return str;
	}

}
	