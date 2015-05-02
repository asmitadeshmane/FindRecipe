package com.action;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.model.FridgeItemsList;
import com.model.RecipeList;
import com.opensymphony.xwork2.ActionSupport;
import com.utils.Constants;
import com.utils.FileReadUtilities;
import com.utils.RecipeFind;
import com.utils.RecipeFindImpl;

public class FindRecipeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File itemFile;
	private String itemFileContentType;
	private String itemFileFileName;
	private File recipeFile;
	private String recipeFileContentType;
	private String recipeFileFileName;
	private String destPath;
	private String csvMessage;
	private String jsonMessage;
	private String recipeFound;
	private FridgeItemsList fridgeItemsList = new FridgeItemsList();
	private RecipeList recipeList = new RecipeList();
	private static final Logger logger = Logger
			.getLogger(FindRecipeAction.class);

	public String execute() {
		csvMessage = FileReadUtilities.readCSVFile(itemFile, itemFileFileName,
				fridgeItemsList);
		jsonMessage = FileReadUtilities.readJsonFile(recipeFile,
				recipeFileFileName, recipeList);
		logger.info(recipeList);

		if (Constants.CSV_UPLOAD_SUCCESS.equals(csvMessage)
				&& Constants.JSON_UPLOAD_SUCCESS.equals(jsonMessage)) {
			RecipeFind recipeFind = new RecipeFindImpl();
			recipeFound = recipeFind.getRecipe(fridgeItemsList, recipeList);
		} else {
			recipeFound = Constants.RECIPE_ERROR_MESSAGE;
		}
		return SUCCESS;
	}

	public File getItemFile() {
		return itemFile;
	}

	public void setItemFile(File itemFile) {
		this.itemFile = itemFile;
	}

	public String getItemFileContentType() {
		return itemFileContentType;
	}

	public void setItemFileContentType(String itemFileContentType) {
		this.itemFileContentType = itemFileContentType;
	}

	public String getItemFileFileName() {
		return itemFileFileName;
	}

	public void setItemFileFileName(String itemFileFileName) {
		this.itemFileFileName = itemFileFileName;
	}

	public File getRecipeFile() {
		return recipeFile;
	}

	public void setRecipeFile(File recipeFile) {
		this.recipeFile = recipeFile;
	}

	public String getRecipeFileContentType() {
		return recipeFileContentType;
	}

	public void setRecipeFileContentType(String recipeFileContentType) {
		this.recipeFileContentType = recipeFileContentType;
	}

	public String getRecipeFileFileName() {
		return recipeFileFileName;
	}

	public void setRecipeFileFileName(String recipeFileFileName) {
		this.recipeFileFileName = recipeFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public FridgeItemsList getFridgeItemsList() {
		return fridgeItemsList;
	}

	public void setFridgeItemsList(FridgeItemsList fridgeItemsList) {
		this.fridgeItemsList = fridgeItemsList;
	}

	public RecipeList getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(RecipeList recipeList) {
		this.recipeList = recipeList;
	}

	public String getRecipeFound() {
		return recipeFound;
	}

	public void setRecipeFound(String recipeFound) {
		this.recipeFound = recipeFound;
	}

	public String getCsvMessage() {
		return csvMessage;
	}

	public void setCsvMessage(String csvMessage) {
		this.csvMessage = csvMessage;
	}

	public String getJsonMessage() {
		return jsonMessage;
	}

	public void setJsonMessage(String jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

	@Override
	public void validate() {
		if (itemFile == null) {
			addFieldError("itemFile", "Select fridge item file!");
		} else if (!FilenameUtils.getExtension(itemFileFileName).equals("csv")) {
			addFieldError("itemFile", "Item file should be of csv type!");
		}

		if (recipeFile == null) {
			addFieldError("recipeFile", "Select recipe file!");
		} else if (!FilenameUtils.getExtension(recipeFileFileName).equals(
				"json")) {
			addFieldError("recipeFile", "Recipe file should be of json type!");
		}

	}
}
