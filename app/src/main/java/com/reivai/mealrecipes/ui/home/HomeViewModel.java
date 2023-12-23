package com.reivai.mealrecipes.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.reivai.mealrecipes.network.response.AreaResponse;
import com.reivai.mealrecipes.network.response.CategoriesResponse;

public class HomeViewModel extends ViewModel {

    private HomeRepository homeRepository;
    private MutableLiveData<CategoriesResponse> categoriesLiveData;
    private MutableLiveData<AreaResponse> areasLiveData;

    public HomeViewModel() {
        homeRepository = new HomeRepository();
    }

    public LiveData<CategoriesResponse> getCategoriesLiveData() {
        if (categoriesLiveData == null) {
            categoriesLiveData = homeRepository.getCategories();
        }
        return categoriesLiveData;
    }

    public LiveData<AreaResponse> getAreasLiveData() {
        if (areasLiveData == null) {
            areasLiveData = homeRepository.getAreas();
        }
        return areasLiveData;
    }
}
