package com.calculator.one;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculater firstOperation= new calculater();
		firstOperation.setOperandOne(10.5);
		firstOperation.setOperation('*');
		firstOperation.setOperandtwo(5.2);
		firstOperation.performOperation();
		firstOperation.getResults();

	}

}
