package com.reivai.mealrecipes.ui.categories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.reivai.mealrecipes.network.NetworkApi;
import com.reivai.mealrecipes.network.NetworkClient;
import com.reivai.mealrecipes.network.response.FilterCategoriesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilterCategoriesRepository {

    private static final String TAG = FilterCategoriesActivity.class.getSimpleName();
    private NetworkApi networkApi;

    public FilterCategoriesRepository() {
        networkApi = NetworkClient.getNetworkClient();
    }

    public MutableLiveData<FilterCategoriesResponse> getFilterCategory(String category) {
        final MutableLiveData<FilterCategoriesResponse> data = new MutableLiveData<>();

        networkApi.getFilterCategories(category).enqueue(new Callback<FilterCategoriesResponse>() {
            @Override
            public void onResponse(Call<FilterCategoriesResponse> call, Response<FilterCategoriesResponse> response) {
                Log.d(TAG, "onResponse: " + response);

                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<FilterCategoriesResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    public MutableLiveData<FilterCategoriesResponse> getFilterArea(String area) {
        final MutableLiveData<FilterCategoriesResponse> data = new MutableLiveData<>();

        networkApi.getFilterArea(area).enqueue(new Callback<FilterCategoriesResponse>() {
            @Override
            public void onResponse(Call<FilterCategoriesResponse> call, Response<FilterCategoriesResponse> response) {
                Log.d(TAG, "onResponse: " + response);

                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<FilterCategoriesResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
