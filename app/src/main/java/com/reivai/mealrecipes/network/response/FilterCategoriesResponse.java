package com.reivai.mealrecipes.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.reivai.mealrecipes.network.model.FilterCategoriesModel;

import java.util.List;

public class FilterCategoriesResponse {

    @Expose
    @SerializedName("meals")
    private List<FilterCategoriesModel> meals;

    public List<FilterCategoriesModel> getMeals() {
        return meals;
    }

    public void setMeals(List<FilterCategoriesModel> meals) {
        this.meals = meals;
    }
}
