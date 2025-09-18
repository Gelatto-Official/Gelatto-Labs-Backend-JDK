package net.gelatto.labs.java_sdk.models;

import java.util.List;

public class CustomIngredientsModel {
    public String id;
    public Double stockPerKg;
    public String name;
    public Double pricePerKg;
    public Double mgPercent;
    public Double sngPercent;
    public Double azPercent;
    public Double stabilizerPercent;
    public List<String> ingredientsIds;
    public List<String> otherIngredientsThatNotExist;

    public CustomIngredientsModel() {
    }

    public CustomIngredientsModel(String id, Double stockPerKg, String name, Double pricePerKg, Double mgPercent, Double sngPercent, Double azPercent, Double stabilizerPercent, List<String> ingredientsIds, List<String> otherIngredientsThatNotExist) {
        this.id = id;
        this.stockPerKg = stockPerKg;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.mgPercent = mgPercent;
        this.sngPercent = sngPercent;
        this.azPercent = azPercent;
        this.stabilizerPercent = stabilizerPercent;
        this.ingredientsIds = ingredientsIds;
        this.otherIngredientsThatNotExist = otherIngredientsThatNotExist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getStockPerKg() {
        return stockPerKg;
    }

    public void setStockPerKg(Double stockPerKg) {
        this.stockPerKg = stockPerKg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public Double getMgPercent() {
        return mgPercent;
    }

    public void setMgPercent(Double mgPercent) {
        this.mgPercent = mgPercent;
    }

    public Double getSngPercent() {
        return sngPercent;
    }

    public void setSngPercent(Double sngPercent) {
        this.sngPercent = sngPercent;
    }

    public Double getAzPercent() {
        return azPercent;
    }

    public void setAzPercent(Double azPercent) {
        this.azPercent = azPercent;
    }

    public Double getStabilizerPercent() {
        return stabilizerPercent;
    }

    public void setStabilizerPercent(Double stabilizerPercent) {
        this.stabilizerPercent = stabilizerPercent;
    }

    public List<String> getIngredientsIds() {
        return ingredientsIds;
    }

    public void setIngredientsIds(List<String> ingredientsIds) {
        this.ingredientsIds = ingredientsIds;
    }

    public List<String> getOtherIngredientsThatNotExist() {
        return otherIngredientsThatNotExist;
    }

    public void setOtherIngredientsThatNotExist(List<String> otherIngredientsThatNotExist) {
        this.otherIngredientsThatNotExist = otherIngredientsThatNotExist;
    }
}

