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
		Chewie.attackTown();
		Chewie.attackTown();
		
//		fly twice
		Chewie.fly();
		Chewie.fly();
		
//		eat two humans
		Chewie.eatHumans();
		
		System.out.print("New ");
		Chewie.displayEnergy();

	}

}
