package com.reivai.mealrecipes.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.reivai.mealrecipes.network.model.AreaModel;

import java.util.List;

public class AreaResponse {

    @Expose
    @SerializedName("meals")
    private List<AreaModel> meals;

    public List<AreaModel> getMeals() {
        return meals;
    }

    public void setMeals(List<AreaModel> meals) {
        this.meals = meals;
    }
}
