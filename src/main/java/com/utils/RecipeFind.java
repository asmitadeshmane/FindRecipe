package com.utils;

import java.util.Date;
import java.util.List;

import com.model.FridgeItems;
import com.model.FridgeItemsList;
import com.model.Ingredients;
import com.model.RecipeList;

public interface RecipeFind {
	
	public String getRecipe(FridgeItemsList fridgeItemsList,RecipeList recipeList);
	public Date searchIngredients(Ingredients ingredients, List<FridgeItems> fridgeItems);
}
