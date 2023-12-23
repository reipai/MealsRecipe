package com.reivai.mealrecipes.ui.meal;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.reivai.mealrecipes.network.NetworkApi;
import com.reivai.mealrecipes.network.NetworkClient;
import com.reivai.mealrecipes.network.response.MealResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealRepository {

    private static final String TAG = MealRepository.class.getSimpleName();
    private NetworkApi networkApi;

    public MealRepository() {
        networkApi = NetworkClient.getNetworkClient();
    }

    public MutableLiveData<MealResponse> getDetailMeals(String id) {
        final MutableLiveData<MealResponse> data = new MutableLiveData<>();

        networkApi.getDetailMeal(id).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                Log.d(TAG, "onResponse: " + response);

                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
