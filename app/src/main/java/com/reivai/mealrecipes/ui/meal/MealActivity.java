package com.reivai.mealrecipes.ui.meal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.reivai.mealrecipes.R;
import com.reivai.mealrecipes.databinding.ActivityMealBinding;
import com.reivai.mealrecipes.network.model.MealsModel;
import com.reivai.mealrecipes.network.response.MealResponse;
import com.reivai.mealrecipes.utils.GlobalFunction;
import com.reivai.sweetalertdialog.SweetAlertDialog;

import org.json.JSONObject;

import java.util.Objects;

public class MealActivity extends AppCompatActivity {

    private ActivityMealBinding binding;
    private SweetAlertDialog alertDialog;
    MealViewModel mealViewModel;
    GlobalFunction globalFunction;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMealBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initUI();
    }

    private void initUI() {
        globalFunction = new GlobalFunction(this);
        mealViewModel = new MealViewModel();
        id = getIntent().getStringExtra("id");

        alertDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        alertDialog.setTitleText("Mohon tunggu").show();

        if (globalFunction.isNetworkAvailable()) {
            getDetailMeals(id);
        } else {
            globalFunction.noInternetConnection(this, alertDialog);
        }

    }

    private void getDetailMeals(String id) {
        mealViewModel.getDetailMeal(id).observe(this, mealResponse -> {
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }

            if (mealResponse != null) {
                MealsModel mealsModel = mealResponse.getMeals().get(0);

                setSupportActionBar(binding.toolbar);
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
                binding.toolbar.setTitle(mealsModel.getStrMeal());
                binding.toolbar.setSubtitle(mealsModel.getStrCategory() + " | " + mealsModel.getStrArea());

                Glide.with(this)
                     .load(mealsModel.getStrMealThumb())
                     .into(binding.ivMeals);



                binding.tvInstruction.setText(mealsModel.getStrInstructions());

                binding.cvYoutube.setOnClickListener(view -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(mealsModel.getStrYoutube()));
                    startActivity(intent);
                });

                if (mealsModel.getStrIngredient1() != null && !mealsModel.getStrIngredient1().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient1().equalsIgnoreCase(" ")) {
                    binding.tvIngredients1.setText("\u2022" + mealsModel.getStrIngredient1());
                } else {
                    binding.tvIngredients1.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient2() != null && !mealsModel.getStrIngredient2().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient2().equalsIgnoreCase(" ")) {
                    binding.tvIngredients2.setText("\u2022" + mealsModel.getStrIngredient2());
                } else {
                    binding.tvIngredients2.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient3() != null && !mealsModel.getStrIngredient3().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient3().equalsIgnoreCase(" ")) {
                    binding.tvIngredients3.setText("\u2022" + mealsModel.getStrIngredient3());
                } else {
                    binding.tvIngredients3.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient4() != null && !mealsModel.getStrIngredient4().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient4().equalsIgnoreCase(" ")) {
                    binding.tvIngredients4.setText("\u2022" + mealsModel.getStrIngredient4());
                } else {
                    binding.tvIngredients4.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient5() != null && !mealsModel.getStrIngredient5().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient5().equalsIgnoreCase(" ")) {
                    binding.tvIngredients5.setText("\u2022" + mealsModel.getStrIngredient5());
                } else {
                    binding.tvIngredients5.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient6() != null && !mealsModel.getStrIngredient6().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient6().equalsIgnoreCase(" ")) {
                    binding.tvIngredients6.setText("\u2022" + mealsModel.getStrIngredient6());
                } else {
                    binding.tvIngredients6.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient7() != null && !mealsModel.getStrIngredient7().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient7().equalsIgnoreCase(" ")) {
                    binding.tvIngredients7.setText("\u2022" + mealsModel.getStrIngredient7());
                } else {
                    binding.tvIngredients7.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient8() != null && !mealsModel.getStrIngredient8().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient8().equalsIgnoreCase(" ")) {
                    binding.tvIngredients8.setText("\u2022" + mealsModel.getStrIngredient8());
                } else {
                    binding.tvIngredients8.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient9() != null && !mealsModel.getStrIngredient9().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient9().equalsIgnoreCase(" ")) {
                    binding.tvIngredients9.setText("\u2022" + mealsModel.getStrIngredient9());
                } else {
                    binding.tvIngredients9.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient10() != null && !mealsModel.getStrIngredient10().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient10().equalsIgnoreCase(" ")) {
                    binding.tvIngredients10.setText("\u2022" + mealsModel.getStrIngredient10());
                } else {
                    binding.tvIngredients10.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient11() != null && !mealsModel.getStrIngredient11().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient11().equalsIgnoreCase(" ")) {
                    binding.tvIngredients11.setText("\u2022" + mealsModel.getStrIngredient11());
                } else {
                    binding.tvIngredients11.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient12() != null && !mealsModel.getStrIngredient12().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient12().equalsIgnoreCase(" ")) {
                    binding.tvIngredients12.setText("\u2022" + mealsModel.getStrIngredient12());
                } else {
                    binding.tvIngredients12.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient13() != null && !mealsModel.getStrIngredient13().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient13().equalsIgnoreCase(" ")) {
                    binding.tvIngredients13.setText("\u2022" + mealsModel.getStrIngredient13());
                } else {
                    binding.tvIngredients13.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient14() != null && !mealsModel.getStrIngredient14().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient14().equalsIgnoreCase(" ")) {
                    binding.tvIngredients14.setText("\u2022" + mealsModel.getStrIngredient14());
                } else {
                    binding.tvIngredients14.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient15() != null && !mealsModel.getStrIngredient15().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient15().equalsIgnoreCase(" ")) {
                    binding.tvIngredients15.setText("\u2022" + mealsModel.getStrIngredient15());
                } else {
                    binding.tvIngredients15.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient16() != null && !mealsModel.getStrIngredient16().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient16().equalsIgnoreCase(" ")) {
                    binding.tvIngredients16.setText("\u2022" + mealsModel.getStrIngredient16());
                } else {
                    binding.tvIngredients16.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient17() != null && !mealsModel.getStrIngredient17().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient17().equalsIgnoreCase(" ")) {
                    binding.tvIngredients17.setText("\u2022" + mealsModel.getStrIngredient17());
                } else {
                    binding.tvIngredients17.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient18() != null && !mealsModel.getStrIngredient18().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient18().equalsIgnoreCase(" ")) {
                    binding.tvIngredients18.setText("\u2022" + mealsModel.getStrIngredient18());
                } else {
                    binding.tvIngredients18.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient19() != null && !mealsModel.getStrIngredient19().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient19().equalsIgnoreCase(" ")) {
                    binding.tvIngredients19.setText("\u2022" + mealsModel.getStrIngredient19());
                } else {
                    binding.tvIngredients19.setVisibility(View.GONE);
                }

                if (mealsModel.getStrIngredient20() != null && !mealsModel.getStrIngredient20().equalsIgnoreCase("")
                        && !mealsModel.getStrIngredient20().equalsIgnoreCase(" ")) {
                    binding.tvIngredients20.setText("\u2022" + mealsModel.getStrIngredient20());
                } else {
                    binding.tvIngredients20.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure1() != null && !mealsModel.getStrMeasure1().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure1().equalsIgnoreCase(" ")) {
                    binding.tvMeasure1.setText(": " + mealsModel.getStrMeasure1());
                } else {
                    binding.tvMeasure1.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure2() != null && !mealsModel.getStrMeasure2().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure2().equalsIgnoreCase(" ")) {
                    binding.tvMeasure2.setText(": " + mealsModel.getStrMeasure2());
                } else {
                    binding.tvMeasure2.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure3() != null && !mealsModel.getStrMeasure3().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure3().equalsIgnoreCase(" ")) {
                    binding.tvMeasure3.setText(": " + mealsModel.getStrMeasure3());
                } else {
                    binding.tvMeasure3.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure4() != null && !mealsModel.getStrMeasure4().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure4().equalsIgnoreCase(" ")) {
                    binding.tvMeasure4.setText(": " + mealsModel.getStrMeasure4());
                } else {
                    binding.tvMeasure4.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure5() != null && !mealsModel.getStrMeasure5().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure5().equalsIgnoreCase(" ")) {
                    binding.tvMeasure5.setText(": " + mealsModel.getStrMeasure5());
                } else {
                    binding.tvMeasure5.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure6() != null && !mealsModel.getStrMeasure6().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure6().equalsIgnoreCase(" ")) {
                    binding.tvMeasure6.setText(": " + mealsModel.getStrMeasure6());
                } else {
                    binding.tvMeasure6.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure7() != null && !mealsModel.getStrMeasure7().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure7().equalsIgnoreCase(" ")) {
                    binding.tvMeasure7.setText(": " + mealsModel.getStrMeasure7());
                } else {
                    binding.tvMeasure7.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure8() != null && !mealsModel.getStrMeasure8().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure8().equalsIgnoreCase(" ")) {
                    binding.tvMeasure8.setText(": " + mealsModel.getStrMeasure8());
                } else {
                    binding.tvMeasure8.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure9() != null && !mealsModel.getStrMeasure9().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure9().equalsIgnoreCase(" ")) {
                    binding.tvMeasure9.setText(": " + mealsModel.getStrMeasure9());
                } else {
                    binding.tvMeasure9.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure10() != null && !mealsModel.getStrMeasure10().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure10().equalsIgnoreCase(" ")) {
                    binding.tvMeasure10.setText(": " + mealsModel.getStrMeasure10());
                } else {
                    binding.tvMeasure10.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure11() != null && !mealsModel.getStrMeasure11().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure11().equalsIgnoreCase(" ")) {
                    binding.tvMeasure11.setText(": " + mealsModel.getStrMeasure11());
                } else {
                    binding.tvMeasure11.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure12() != null && !mealsModel.getStrMeasure12().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure12().equalsIgnoreCase(" ")) {
                    binding.tvMeasure12.setText(": " + mealsModel.getStrMeasure12());
                } else {
                    binding.tvMeasure12.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure13() != null && !mealsModel.getStrMeasure13().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure13().equalsIgnoreCase(" ")) {
                    binding.tvMeasure13.setText(": " + mealsModel.getStrMeasure13());
                } else {
                    binding.tvMeasure13.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure14() != null && !mealsModel.getStrMeasure14().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure14().equalsIgnoreCase(" ")) {
                    binding.tvMeasure14.setText(": " + mealsModel.getStrMeasure14());
                } else {
                    binding.tvMeasure14.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure15() != null && !mealsModel.getStrMeasure15().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure15().equalsIgnoreCase(" ")) {
                    binding.tvMeasure15.setText(": " + mealsModel.getStrMeasure15());
                } else {
                    binding.tvMeasure15.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure16() != null && !mealsModel.getStrMeasure16().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure16().equalsIgnoreCase(" ")) {
                    binding.tvMeasure16.setText(": " + mealsModel.getStrMeasure16());
                } else {
                    binding.tvMeasure16.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure17() != null && !mealsModel.getStrMeasure17().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure17().equalsIgnoreCase(" ")) {
                    binding.tvMeasure17.setText(": " + mealsModel.getStrMeasure17());
                } else {
                    binding.tvMeasure17.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure18() != null && !mealsModel.getStrMeasure18().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure18().equalsIgnoreCase(" ")) {
                    binding.tvMeasure18.setText(": " + mealsModel.getStrMeasure18());
                } else {
                    binding.tvMeasure18.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure19() != null && !mealsModel.getStrMeasure19().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure19().equalsIgnoreCase(" ")) {
                    binding.tvMeasure19.setText(": " + mealsModel.getStrMeasure19());
                } else {
                    binding.tvMeasure19.setVisibility(View.GONE);
                }

                if (mealsModel.getStrMeasure20() != null && !mealsModel.getStrMeasure20().equalsIgnoreCase("")
                        && !mealsModel.getStrMeasure20().equalsIgnoreCase(" ")) {
                    binding.tvMeasure20.setText(": " + mealsModel.getStrMeasure20());
                } else {
                    binding.tvMeasure20.setVisibility(View.GONE);
                }


            }
        });
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