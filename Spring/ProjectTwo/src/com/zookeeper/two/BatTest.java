package com.zookeeper.two;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bat Chewie = new Bat();
		System.out.println("Chewie Gorilla");
		System.out.print("Default ");
		Chewie.displayEnergy();
		
//		attack three towns
		Chewie.attackTown();
		Chewie.displayEnergy();
		Chewie.attackTown();
		Chewie.displayEnergy();
		Chewie.attackTown();
		Chewie.displayEnergy();
		
//		fly twice
		Chewie.fly();
		Chewie.displayEnergy();
		Chewie.fly();
		Chewie.displayEnergy();
		
//		eat two humans
		Chewie.eatHumans();
		Chewie.displayEnergy();
		Chewie.eatHumans();
		Chewie.displayEnergy();
		
		System.out.print("New ");
		Chewie.displayEnergy();

	}

}
