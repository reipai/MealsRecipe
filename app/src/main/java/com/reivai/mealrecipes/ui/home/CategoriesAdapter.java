package com.reivai.mealrecipes.ui.home;

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
import com.reivai.mealrecipes.network.model.CategoriesModel;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    Context context;
    List<CategoriesModel> mCategories;

    public CategoriesAdapter(Context context, List<CategoriesModel> mCategories) {
        this.context = context;
        this.mCategories = mCategories;
    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        CategoriesModel categories = mCategories.get(position);

        Glide.with(context)
                .load(categories.getStrCategoryThumb())
                .apply(new RequestOptions().override(800, 800))
                .into(holder.ivCategories);

        holder.tvCategories.setText(categories.getStrCategory());

        holder.cvCategories.setOnClickListener(view -> {
            if (context instanceof HomeActivity) {
                ((HomeActivity)context).toCategoriesMeal(categories);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCategories;
        TextView tvCategories;
        CardView cvCategories;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategories = itemView.findViewById(R.id.ivCategories);
            tvCategories = itemView.findViewById(R.id.tvCategories);
            cvCategories = itemView.findViewById(R.id.cvCategories);
        }
    }
}
