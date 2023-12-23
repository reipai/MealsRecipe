package com.reivai.mealrecipes.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.reivai.mealrecipes.network.model.CategoriesModel;

import java.util.List;

public class CategoriesResponse {

    @Expose
    @SerializedName("categories")
    public List<CategoriesModel> categories;

    public List<CategoriesModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesModel> categories) {
        this.categories = categories;
    }
}
