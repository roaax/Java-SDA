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
		Chewie.throwSomething();
		Chewie.throwSomething();
		
//		eat bananas twice
		Chewie.eatBananas();
		Chewie.eatBananas();
		
//		climb once
		Chewie.climb();
		
		System.out.print("New ");
		Chewie.displayEnergy();
}

}
