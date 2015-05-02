package com.model;

import java.util.List;

public class FridgeItemsList {

	private List<FridgeItems> fridgeItemsList;

	public List<FridgeItems> getFridgeItemsList() {
		return fridgeItemsList;
	}

	public void setFridgeItemsList(List<FridgeItems> fridgeItemsList) {
		this.fridgeItemsList = fridgeItemsList;
	}
	
	@Override
	public String toString() {
		StringBuffer itemList = new StringBuffer();
		
		if (fridgeItemsList.isEmpty()) {
			itemList.append("No items in Fridge!!!");
		} else {
			for (FridgeItems fridgeItems : fridgeItemsList) {
				itemList.append(fridgeItems.getItem()+","+fridgeItems.getAmount()+","+fridgeItems.getUnit()+","+fridgeItems.getUseBy()+"\n");
			}
		}
		
		return itemList.toString();
	}
	
}
