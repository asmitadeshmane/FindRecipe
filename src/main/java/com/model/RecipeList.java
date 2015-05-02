package com.model;

import java.util.List;

public class RecipeList {
	
	private List<Recipe> recipeList;

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	
	@Override
	public String toString() {
		StringBuffer itemList = new StringBuffer();
		
		if (recipeList.isEmpty()) {
			itemList.append("No recipes!!!");
		} else {
			for (Recipe recipe : recipeList) {
				itemList.append(recipe.toString());
			}
		}
		
		return itemList.toString();
	}
}
