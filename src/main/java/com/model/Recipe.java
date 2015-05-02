package com.model;

import java.util.List;

public class Recipe {
	private String name;
	private List<Ingredients> ingredients;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ingredients> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	
	@Override
	public String toString() {
		return "name : "+this.name+", "+this.ingredients+"\n";
	}
	
}
