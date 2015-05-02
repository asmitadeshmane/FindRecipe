package com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.model.FridgeItems;
import com.model.FridgeItemsList;
import com.model.Recipe;
import com.model.RecipeList;

public class FileReadUtilities {

	private static final Logger logger = Logger.getLogger(FileReadUtilities.class);

	public static String readCSVFile(File file, String fileName, FridgeItemsList fridgeItemsList) {

		String message = Constants.CSV_UPLOAD_SUCCESS;
		String line;
		FileReader fileReader=null;
		BufferedReader bufferedReader = null;
		List<FridgeItems> itemsList = null;
		try {
			if(file == null || fileName == null || fileName.equals("")) {
				throw new FileNotFoundException();
			}
			if(fridgeItemsList == null) {
				throw new ItemListNotDefineException(Constants.ITEM_LIST_NOT_DEFINED);
			}
			Date currentDate = new Date();
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			itemsList = new ArrayList<FridgeItems>();

			while ((line = bufferedReader.readLine()) != null) {
				line = line.replace(Constants.DOUBLE_QUOTE, Constants.BLANK);
				String items[] = line.split(Constants.COMMA_SEPARATOR);
				if (items.length == 4) {
					try {
						String item = items[0];
						int amount = Integer.parseInt(items[1]);
						Unit unit = Unit.valueOf(items[2].toUpperCase());
						DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);
						Date useBy = df.parse(items[3]);
						if (currentDate.compareTo(useBy) <= 0) {
							FridgeItems fridgeItem = new FridgeItems();

							fridgeItem.setItem(item);
							fridgeItem.setAmount(amount);
							fridgeItem.setUnit(unit);
							fridgeItem.setUseBy(useBy);

							itemsList.add(fridgeItem);
						}
					} catch (Exception e) {
						message = Constants.CSV_FORMAT_ERROR;
						logger.error(e.getMessage());
					}
				} else {
					message = Constants.CSV_FORMAT_ERROR;
				}
				fridgeItemsList.setFridgeItemsList(itemsList);
			}
			logger.info(fridgeItemsList);
			fileReader.close();
		} catch(ItemListNotDefineException e) {
			message = Constants.ITEM_LIST_NOT_DEFINED;
			logger.error(e.getMessage());
		} catch(FileNotFoundException e) {
			message = Constants.FILE_NOT_FOUND;
			logger.error(e.getMessage());
		} catch (IOException e) {
			message = Constants.FILEREAD_ERROR;
			logger.error(e.getMessage());
		}
		return message;
	}

	public static String readJsonFile(File file, String fileName, RecipeList recipeList) {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		String ingredData;
		String message = Constants.JSON_UPLOAD_SUCCESS;
		
		try {
			if(file == null || fileName == null || fileName.equals("")) {
				throw new FileNotFoundException();
			}
			
			if(recipeList == null) {
				throw new RecipeListNotDefineException(Constants.RECIPE_LIST_NOT_DEFINED);
			}
			
			ingredData = FileUtils.readFileToString(file);
			JsonArray jArray = parser.parse(ingredData).getAsJsonArray();
			List<Recipe> rl = new ArrayList<Recipe>();

			for (JsonElement element : jArray) {
				rl.add(gson.fromJson(element, Recipe.class));
			}
			recipeList.setRecipeList(rl);
			logger.info(recipeList);

		} catch(RecipeListNotDefineException e) {
			message = Constants.RECIPE_LIST_NOT_DEFINED;
			logger.error(e.getMessage());
		} catch(FileNotFoundException e) {
			message = Constants.FILE_NOT_FOUND;
			logger.error(e.getMessage());
		} catch (IOException e) {
			message = Constants.FILEREAD_ERROR;
			logger.error(e.getMessage());
		} catch (Exception e) {
			message = Constants.JSON_PARSER_ERROR;
			logger.error(e.getMessage());
		}
		return message;
	}

}
