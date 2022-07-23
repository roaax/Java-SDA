package com.zookeeper.two;

public class Bat extends Mammal{
	
	public Bat() {
//		 Its default energy is much higher than most mammals, its energy level is 300
		this.setEnergyLevel(300);
	}
	public void fly() {		
		System.out.println("the sound a bat taking off");
		int energy=this.getEnergyLevel()-50;
		this.setEnergyLevel(energy);
		
	}
	public void eatHumans() {
		System.out.println("so- well, never mind");
		int energy=this.getEnergyLevel()+25;
		this.setEnergyLevel(energy);

	}
	public void attackTown() {
		System.out.println("the sound of a town on fire ");
		int energy=this.getEnergyLevel()-100;
		this.setEnergyLevel(energy);
	}
}
