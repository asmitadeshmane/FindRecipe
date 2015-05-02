package com.utils;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.model.FridgeItems;
import com.model.FridgeItemsList;
import com.model.Ingredients;
import com.model.Recipe;
import com.model.RecipeList;

public class RecipeFindImpl implements RecipeFind {
	private static final Logger logger = Logger.getLogger(RecipeFindImpl.class); 

	public String getRecipe(FridgeItemsList fridgeItemsList,
			RecipeList recipeList) {
		List<Recipe> recipes;
		List<FridgeItems> fridgeItems;

		Date useByDate = new Date();
		Date closestUseByDate = null;
		Boolean ingredientFound = true;
		String recipeName = Constants.RECIPE_TAKEOUT_MESSAGE;
		try {

			if (fridgeItemsList == null) {
				throw new ItemListNotDefineException(
						Constants.ITEM_LIST_NOT_DEFINED);
			}

			if (recipeList == null) {
				throw new RecipeListNotDefineException(
						Constants.RECIPE_LIST_NOT_DEFINED);
			}
			recipes = recipeList.getRecipeList();
			fridgeItems = fridgeItemsList.getFridgeItemsList();

			for (Recipe recipe : recipes) {
				List<Ingredients> ingredientList = recipe.getIngredients();
				String name = recipe.getName();
				Date checkClosestUseByDate = null;

				for (Ingredients ingredient : ingredientList) {
					useByDate = searchIngredients(ingredient, fridgeItems);
					if (useByDate != null) {
						if (checkClosestUseByDate == null
								|| useByDate.compareTo(checkClosestUseByDate) < 0) {
							ingredientFound = true;
							checkClosestUseByDate = useByDate;
						}
					} else {
						ingredientFound = false;
						break;
					}
				}
				if (ingredientFound) {
					if (closestUseByDate == null
							|| checkClosestUseByDate
									.compareTo(closestUseByDate) < 0) {
						closestUseByDate = checkClosestUseByDate;
						recipeName = name;
					}
				}
			}
		} catch (RecipeListNotDefineException e) {
			recipeName = Constants.RECIPE_LIST_NOT_DEFINED;
		} catch (ItemListNotDefineException e) {
			recipeName = Constants.ITEM_LIST_NOT_DEFINED;
		}
		return recipeName;
	}

	public Date searchIngredients(Ingredients ingredients,
			List<FridgeItems> fridgeItems) {
		
		Date useByDate = null;
		try {
			if(ingredients == null) {
				throw new IngredientsNotDefineException(Constants.INGREDIENTS_NOT_DEFINED);
			}
			if(fridgeItems == null) {
				throw new ItemListNotDefineException(Constants.ITEM_LIST_NOT_DEFINED);
			}
		
			for (FridgeItems item : fridgeItems) {
				if (item.getItem().equalsIgnoreCase(ingredients.getItem())
						&& item.getAmount() >= ingredients.getAmount()
						&& item.getUnit().toString()
								.equalsIgnoreCase(ingredients.getUnit().toString())) {
					useByDate = item.getUseBy();
					break;
				}
			}
		} catch(IngredientsNotDefineException e) {
			logger.error(e.getMessage());
		} catch(ItemListNotDefineException e) {
			logger.error(e.getMessage());
		}

		return useByDate;
	}

}
