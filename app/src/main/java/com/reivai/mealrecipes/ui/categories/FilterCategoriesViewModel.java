package com.reivai.mealrecipes.ui.categories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.reivai.mealrecipes.network.response.FilterCategoriesResponse;

public class FilterCategoriesViewModel extends ViewModel {

    private FilterCategoriesRepository repository;
    private MutableLiveData<FilterCategoriesResponse> categoriesResponse;

    public FilterCategoriesViewModel() {
        repository = new FilterCategoriesRepository();
    }

    public LiveData<FilterCategoriesResponse> getFilterCategoryLiveData(String category) {
        if (categoriesResponse == null) {
            categoriesResponse = repository.getFilterCategory(category);
        }
        return categoriesResponse;
    }

    public LiveData<FilterCategoriesResponse> getFilterAreaLiveData(String area) {
        if (categoriesResponse == null) {
            categoriesResponse = repository.getFilterArea(area);
        }
        return categoriesResponse;
    }
}
