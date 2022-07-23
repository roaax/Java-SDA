package com.abstractart;

public class Painting extends Art{
	public String paintType;
	
	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("Paint Type " + paintType);
	}

}
