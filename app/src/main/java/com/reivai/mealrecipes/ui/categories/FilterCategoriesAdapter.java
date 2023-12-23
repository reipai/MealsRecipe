package com.reivai.mealrecipes.ui.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.reivai.mealrecipes.R;
import com.reivai.mealrecipes.network.model.FilterCategoriesModel;

import java.util.List;

public class FilterCategoriesAdapter extends RecyclerView.Adapter<FilterCategoriesAdapter.ViewHolder> {

    Context context;
    List<FilterCategoriesModel> mFilterModel;

    public FilterCategoriesAdapter(Context context, List<FilterCategoriesModel> mFilterModel) {
        this.context = context;
        this.mFilterModel = mFilterModel;
    }

    @NonNull
    @Override
    public FilterCategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_filter_categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterCategoriesAdapter.ViewHolder holder, int position) {
        FilterCategoriesModel filterCategory = mFilterModel.get(position);

        Glide.with(context)
                .load(filterCategory.getStrMealThumb())
                .apply(new RequestOptions().override(600, 600))
                .into(holder.ivCategories);

        holder.tvCategories.setText(filterCategory.getStrMeal());

        holder.cvCategories.setOnClickListener(view -> {
            if (context instanceof FilterCategoriesActivity) {
                ((FilterCategoriesActivity)context).toDetailMeals(filterCategory.getIdMeal());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilterModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCategories, ivFavorite;
        TextView tvCategories;
        CardView cvCategories;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategories = itemView.findViewById(R.id.ivCategories);
            ivFavorite = itemView.findViewById(R.id.ivFavorite);
            tvCategories = itemView.findViewById(R.id.tvCategories);
            cvCategories = itemView.findViewById(R.id.cvFilterCategories);
        }
    }
}
