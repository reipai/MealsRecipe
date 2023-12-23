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

import com.reivai.mealrecipes.R;
import com.reivai.mealrecipes.network.model.AreaModel;

import org.w3c.dom.Text;

import java.util.List;

public class AreasAdapter extends RecyclerView.Adapter<AreasAdapter.ViewHolder> {

    Context context;
    List<AreaModel> mAreas;

    public AreasAdapter(Context context, List<AreaModel> mAreas) {
        this.context = context;
        this.mAreas = mAreas;
    }

    @NonNull
    @Override
    public AreasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AreasAdapter.ViewHolder holder, int position) {
        AreaModel areaCountry = mAreas.get(position);

        holder.tvCategories.setText(areaCountry.getStrArea());
        holder.ivCategories.setVisibility(View.GONE);

        holder.cvCategories.setOnClickListener(view -> {
            if (context instanceof HomeActivity) {
                ((HomeActivity)context).toAreasMeal(areaCountry);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAreas.size();
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
