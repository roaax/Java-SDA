package com.zookeeper.one;


public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("the gorilla has thrown something");
		int energy=this.getEnergyLevel()-5;
		this.setEnergyLevel(energy);
//		or 
//		i can use it without getter and setter by just call the member variable
//      and assign -= | += to it 
//		System.out.println("the gorilla has thrown something");
//		energyLevel-=5;
//		displayEnergy();
//		
//		
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
