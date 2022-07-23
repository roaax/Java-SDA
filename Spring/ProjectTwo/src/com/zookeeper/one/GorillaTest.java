package com.zookeeper.one;
public class GorillaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla Chewie = new Gorilla();
		System.out.println("Chewie Gorilla");
		System.out.print("Default ");
		Chewie.displayEnergy();
		
//		throw three things
		Chewie.throwSomething();
		Chewie.displayEnergy();
		Chewie.throwSomething();
		Chewie.displayEnergy();
		Chewie.throwSomething();
		Chewie.displayEnergy();
		
//		eat bananas twice
		Chewie.eatBananas();
		Chewie.displayEnergy();
		Chewie.eatBananas();
		Chewie.displayEnergy();
		
//		climb once
		Chewie.climb();
		Chewie.displayEnergy();
		
		System.out.print("New ");
		Chewie.displayEnergy();
}

}
