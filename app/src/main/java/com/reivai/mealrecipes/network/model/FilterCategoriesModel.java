package com.reivai.mealrecipes.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterCategoriesModel {
    @Expose
    @SerializedName("idMeal")
    private String idMeal;
    @Expose
    @SerializedName("strMealThumb")
    private String strMealThumb;
    @Expose
    @SerializedName("strMeal")
    private String strMeal;

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }
}
