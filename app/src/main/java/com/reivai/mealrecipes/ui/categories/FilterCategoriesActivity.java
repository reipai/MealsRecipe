package com.reivai.mealrecipes.ui.categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.reivai.mealrecipes.R;
import com.reivai.mealrecipes.databinding.ActivityCategoriesBinding;
import com.reivai.mealrecipes.network.model.AreaModel;
import com.reivai.mealrecipes.network.model.CategoriesModel;
import com.reivai.mealrecipes.network.model.FilterCategoriesModel;
import com.reivai.mealrecipes.ui.meal.MealActivity;
import com.reivai.mealrecipes.utils.GlobalFunction;
import com.reivai.sweetalertdialog.SweetAlertDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilterCategoriesActivity extends AppCompatActivity {

    private ActivityCategoriesBinding binding;
    private SweetAlertDialog alertDialog;
    private FilterCategoriesAdapter adapter;
    private List<FilterCategoriesModel> filterCategoryList;
    FilterCategoriesViewModel filterCategoriesViewModel;
    GlobalFunction globalFunction;
    CategoriesModel modelCategory;
    AreaModel modelArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initUI();

    }

    private void initUI() {
        filterCategoryList = new ArrayList<>();
        adapter = new FilterCategoriesAdapter(this, filterCategoryList);
        globalFunction = new GlobalFunction(this);
        filterCategoriesViewModel = new FilterCategoriesViewModel();
        modelCategory = getIntent().getParcelableExtra("categories");
        modelArea = getIntent().getParcelableExtra("areas");




        alertDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        alertDialog.setTitleText("Mohon tunggu").show();

        if (globalFunction.isNetworkAvailable()) {
            if (modelCategory != null) {
                setSupportActionBar(binding.toolbar);
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
                binding.toolbar.setTitle("Food List " + modelCategory.getStrCategory());

                Glide.with(this).load(modelCategory.getStrCategoryThumb()).into(binding.ivCatBg);
                Glide.with(this).load(modelCategory.getStrCategoryThumb()).into(binding.ivCategories);
                binding.tvDescCategories.setText(modelCategory.getStrCategoryDescription());

                getFilterCategoriesList(modelCategory.getStrCategory());
            } else if (modelArea != null) {
                setSupportActionBar(binding.toolbar);
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
                binding.toolbar.setTitle("Food List " + modelArea.getStrArea());
                binding.cvPreview.setVisibility(View.GONE);
                getFilterAreasList(modelArea.getStrArea());
            }
        } else {
            globalFunction.noInternetConnection(this, alertDialog);
        }

        binding.rvCategories.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvCategories.setHasFixedSize(true);
        binding.rvCategories.setAdapter(adapter);
    }

    private void getFilterCategoriesList(String category) {
        filterCategoriesViewModel.getFilterCategoryLiveData(category).observe(this, filterCategoriesResponse -> {
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }

            if (filterCategoriesResponse != null) {
                filterCategoryList.addAll(filterCategoriesResponse.getMeals());
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void getFilterAreasList(String area) {
        filterCategoriesViewModel.getFilterAreaLiveData(area).observe(this, filterCategoriesResponse -> {
            filterCategoryList.clear();
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }

            if (filterCategoriesResponse != null) {
                filterCategoryList.addAll(filterCategoriesResponse.getMeals());
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void toDetailMeals(String id) {
        Intent intent = new Intent(this, MealActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}