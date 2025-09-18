package net.gelatto.labs.java_sdk.models;

import java.util.List;

public class RecipeModel {
    public String id;
    public String name;
    public String description;
    public String gelatoType; // CREAM or WATER
    public Double fatPercentageGoal;
    public List<String> ingredientsIds;
    public Double stockPieces;
    public Double pricePerPiece;

    public RecipeModel() {}
}

