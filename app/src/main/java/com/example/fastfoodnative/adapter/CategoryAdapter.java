package com.example.fastfoodnative.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fastfoodnative.R;
import com.example.fastfoodnative.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    List<CategoryModel> listCategories;

    public CategoryAdapter(List<CategoryModel> listCategories) {
        this.listCategories = listCategories;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        CategoryModel categoryModel = listCategories.get(position);
        if (categoryModel == null) {
            return;
        }
        holder.nameCategory.setText(categoryModel.getNameCategory());

        String url = categoryModel.getImgCategory();
        Glide
                .with(holder.itemView.getContext())
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.svg_img)
                .into(holder.imgCategory);
    }

    @Override
    public int getItemCount() {
        return listCategories == null ? 0 : listCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout containerCategory;
        ImageView imgCategory;
        TextView nameCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            containerCategory = itemView.findViewById(R.id.vh_category_container);
            imgCategory = itemView.findViewById(R.id.vh_category_img);
            nameCategory = itemView.findViewById(R.id.vh_category_name);
        }
    }
}
