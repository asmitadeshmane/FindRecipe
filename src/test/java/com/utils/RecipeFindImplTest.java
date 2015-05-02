package com.utils;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.model.FridgeItems;
import com.model.FridgeItemsList;
import com.model.Ingredients;
import com.model.RecipeList;

public class RecipeFindImplTest {
	
	static RecipeFind recipeFind;
	
	@BeforeClass
	public static void init() {
		recipeFind = new RecipeFindImpl();
	}

	@Test
	public void getRecipe() {
		FridgeItemsList fridgeItemsList=null;
		RecipeList recipeList=null;
		
		assertEquals(recipeFind.getRecipe(fridgeItemsList, recipeList), Constants.ITEM_LIST_NOT_DEFINED);
		
		fridgeItemsList = new FridgeItemsList();
		assertEquals(recipeFind.getRecipe(fridgeItemsList, recipeList), Constants.RECIPE_LIST_NOT_DEFINED);
	}
	
	@Test
	public void searchIngredients() {
		Ingredients ingredients = null;
		List<FridgeItems> fridgeItems = null;
		
		assertEquals(recipeFind.searchIngredients(ingredients, fridgeItems), null);
		ingredients = new Ingredients();
		assertEquals(recipeFind.searchIngredients(ingredients, fridgeItems), null);
	}

	@AfterClass
	public static void destroy() {
		recipeFind = null;
	}
}
