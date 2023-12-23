package com.reivai.mealrecipes.ui.meal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.reivai.mealrecipes.network.response.MealResponse;

public class MealViewModel extends ViewModel {

    private MealRepository mealRepository;
    private MutableLiveData<MealResponse> mealLiveData;

    public MealViewModel() {
        mealRepository = new MealRepository();
    }

    public LiveData<MealResponse> getDetailMeal(String id) {
        if (mealLiveData == null) {
            mealLiveData = mealRepository.getDetailMeals(id);
        }

        return mealLiveData;
    }
}
