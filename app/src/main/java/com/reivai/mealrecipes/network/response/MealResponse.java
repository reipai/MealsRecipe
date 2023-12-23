package com.reivai.mealrecipes.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.reivai.mealrecipes.network.model.MealsModel;

import java.util.List;

public class MealResponse {


    @Expose
    @SerializedName("meals")
    private List<MealsModel> meals;

    public List<MealsModel> getMeals() {
        return meals;
    }

    public void setMeals(List<MealsModel> meals) {
        this.meals = meals;
    }
}
