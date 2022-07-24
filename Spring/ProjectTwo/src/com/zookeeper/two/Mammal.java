package com.zookeeper.two;

public class Mammal{
	private int energyLevel;
	
	//constructor - make energy level default value
	public Mammal(){
	//	Every mammal should have an energy level (default 100)
		this.energyLevel = 100;
	}
	
	// getter
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	//setter
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	/*They should all be able to display their energy levels when asked through 
	  the displayEnergy method, which should print and return the energy level.*/
	public int displayEnergy() {
		System.out.println("Energy Level : " + energyLevel);
		return energyLevel;	
	}

}
