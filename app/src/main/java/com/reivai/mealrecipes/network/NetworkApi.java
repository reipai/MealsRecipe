package com.reivai.mealrecipes.network;

import com.reivai.mealrecipes.network.response.AreaResponse;
import com.reivai.mealrecipes.network.response.CategoriesResponse;
import com.reivai.mealrecipes.network.response.FilterCategoriesResponse;
import com.reivai.mealrecipes.network.response.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkApi {

    @GET("categories.php")
    Call<CategoriesResponse> getCategories();

    @GET("list.php?a=list")
    Call<AreaResponse> getCountry();

    @GET("filter.php")
    Call<FilterCategoriesResponse> getFilterCategories(@Query("c") String categories);

    @GET("filter.php")
    Call<FilterCategoriesResponse> getFilterArea(@Query("a") String area);

    @GET("lookup.php")
    Call<MealResponse> getDetailMeal(@Query("i") String id);
}
