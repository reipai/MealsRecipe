package com.reivai.mealrecipes.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.reivai.mealrecipes.network.NetworkApi;
import com.reivai.mealrecipes.network.NetworkClient;
import com.reivai.mealrecipes.network.response.AreaResponse;
import com.reivai.mealrecipes.network.response.CategoriesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {

    private static final String TAG = HomeRepository.class.getSimpleName();
    private NetworkApi networkApi;

    public HomeRepository() {
        networkApi = NetworkClient.getNetworkClient();
    }

    public MutableLiveData<CategoriesResponse> getCategories() {
        final MutableLiveData<CategoriesResponse> data = new MutableLiveData<>();

        networkApi.getCategories()
                .enqueue(new Callback<CategoriesResponse>() {
                    @Override
                    public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                        Log.d(TAG, "onResponse: " + response);

                        if (response.isSuccessful()) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });

        return data;
    }

    public MutableLiveData<AreaResponse> getAreas() {
        final MutableLiveData<AreaResponse> data = new MutableLiveData<>();

        networkApi.getCountry()
                .enqueue(new Callback<AreaResponse>() {
                    @Override
                    public void onResponse(Call<AreaResponse> call, Response<AreaResponse> response) {
                        Log.d(TAG, "onResponse: " + response);

                        if (response.isSuccessful()) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<AreaResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
