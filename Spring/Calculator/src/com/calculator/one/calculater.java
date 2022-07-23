package com.calculator.one;

public class calculater {
	private double operandOne;
	private double operandtwo;
	private char operation;
	private double result;
	
//	Getter & Setter
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandtwo() {
		return operandtwo;
	}
	public void setOperandtwo(double operandtwo) {
		this.operandtwo = operandtwo;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
// 	This method contains all operations that we need , i store the restult of operation in result variable
	public void performOperation() {
		if (operation == '+') {
			 result= operandOne+operandtwo;
			System.out.println("Adding result is"+result);
		}else if (operation == '-') {
			result= operandOne-operandtwo;
			System.out.println("Subtracting result is "+result);
		}else {
			System.out.println("Error! You have to pass either + or - character");
		}
		
	}
// 	 This method will return the result (that i already stored it in performOperation operation)
	public double getResults() {
		return result;
	}

}
