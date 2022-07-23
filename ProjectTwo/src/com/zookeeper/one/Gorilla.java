package com.zookeeper.one;


public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("the gorilla has thrown something");
		int energy=this.getEnergyLevel()-5;
		this.setEnergyLevel(energy);
		
	}
	public void eatBananas() {
		System.out.println("the gorilla's satisfaction");
		int energy=this.getEnergyLevel()+10;
		this.setEnergyLevel(energy);

	}
	public void climb() {
		System.out.println("the gorilla has climbed a tree");
		int energy=this.getEnergyLevel()-10;
		this.setEnergyLevel(energy);
	}
		
}
