package com.model;

import com.utils.Unit;

public class Ingredients {
	
	private String item;
	private int amount;
	private Unit unit;

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "item : "+this.item+" amount : "+this.amount+" unit : "+this.unit;
	}
}
