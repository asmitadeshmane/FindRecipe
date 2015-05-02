package com.utils;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.model.FridgeItemsList;
import com.model.RecipeList;

public class FileReadUtilitiesTest {
	
	@Test
	public void readCSVFile() {
		File file = null; 
		String fileName = null; 
		FridgeItemsList fridgeItemsList = null;
		
		assertEquals(FileReadUtilities.readCSVFile(file, fileName, fridgeItemsList), Constants.FILE_NOT_FOUND);
		
		file = new File("items.csv");
		assertEquals(FileReadUtilities.readCSVFile(file, fileName, fridgeItemsList), Constants.FILE_NOT_FOUND);
		
		fileName = "items.csv";
		assertEquals(FileReadUtilities.readCSVFile(file, fileName, fridgeItemsList), Constants.ITEM_LIST_NOT_DEFINED);
		
	}
	
	@Test
	public void readJsonFile() {
		File file = null; 
		String fileName = null; 
		RecipeList recipeList = null;
		
		assertEquals(FileReadUtilities.readJsonFile(file, fileName, recipeList), Constants.FILE_NOT_FOUND);
		
		file = new File("recipe.json");
		assertEquals(FileReadUtilities.readJsonFile(file, fileName, recipeList), Constants.FILE_NOT_FOUND);
		
		fileName = "recipe.json";
		assertEquals(FileReadUtilities.readJsonFile(file, fileName, recipeList), Constants.RECIPE_LIST_NOT_DEFINED);
	}

}
