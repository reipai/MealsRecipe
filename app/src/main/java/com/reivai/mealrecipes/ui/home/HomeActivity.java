package com.reivai.mealrecipes.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.reivai.mealrecipes.R;
import com.reivai.mealrecipes.databinding.ActivityHomeBinding;
import com.reivai.mealrecipes.network.model.AreaModel;
import com.reivai.mealrecipes.network.model.CategoriesModel;
import com.reivai.mealrecipes.ui.categories.FilterCategoriesActivity;
import com.reivai.mealrecipes.utils.GlobalFunction;
import com.reivai.sweetalertdialog.SweetAlertDialog;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private SweetAlertDialog alertDialog;
    private CategoriesAdapter adapterCategories;
    private AreasAdapter adapterAreas;
    private List<CategoriesModel> categoriesList;
    private List<AreaModel> areaList;
    HomeViewModel homeViewModel;
    GlobalFunction globalFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        setSupportActionBar(binding.toolbar);

        initUI();

        globalFunction = new GlobalFunction(this);
        homeViewModel = new HomeViewModel();

        alertDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        alertDialog.setTitleText("Mohon tunggu").show();
        if (globalFunction.isNetworkAvailable()) {
            getCategoriesList();
            getAreasList();
        } else {
            globalFunction.noInternetConnection(this, alertDialog);
        }

    }

    private void initUI() {
        categoriesList      = new ArrayList<>();
        areaList            = new ArrayList<>();
        adapterCategories   = new CategoriesAdapter(this, categoriesList);
        adapterAreas        = new AreasAdapter(this, areaList);

        binding.rvCategories.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvCategories.setHasFixedSize(true);
        binding.rvCategories.setAdapter(adapterCategories);

        binding.rvCountry.setLayoutManager(new GridLayoutManager(this, 3));
        binding.rvCountry.setHasFixedSize(true);
        binding.rvCountry.setAdapter(adapterAreas);
    }

    private void getCategoriesList() {
        homeViewModel.getCategoriesLiveData().observe(this, categoriesResponse -> {
            categoriesList.clear();
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }

            if (categoriesResponse != null) {
                categoriesList.addAll(categoriesResponse.getCategories());
                adapterCategories.notifyDataSetChanged();
            }
        });
    }

    private void getAreasList() {
        homeViewModel.getAreasLiveData().observe(this, areaResponse -> {
            areaList.clear();
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }

            if (areaResponse != null) {
                areaList.addAll(areaResponse.getMeals());
                adapterAreas.notifyDataSetChanged();
            }
        });
    }

    public void toCategoriesMeal(CategoriesModel model) {
        Intent intent = new Intent(this, FilterCategoriesActivity.class);
        intent.putExtra("categories", model);
        startActivity(intent);
    }

    public void toAreasMeal(AreaModel model) {
        Intent intent = new Intent(this, FilterCategoriesActivity.class);
        intent.putExtra("areas", model);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_fav) {

        }
        return super.onOptionsItemSelected(item);
    }
}