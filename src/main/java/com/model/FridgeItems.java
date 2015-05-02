package com.model;

import java.util.Date;

import com.utils.Unit;

public class FridgeItems {
	private String item;
	private int amount;
	private Unit unit;
	private Date useBy;

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
	public Date getUseBy() {
		return useBy;
	}
	public void setUseBy(Date useBy) {
		this.useBy = useBy;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.item+", "+this.amount+", "+this.unit+", "+this.useBy;
	}
}
