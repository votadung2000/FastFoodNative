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

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int TYPE_CATEGORY_VERTICAL = 1;
    private static int TYPE_CATEGORY_HORIZONTAL = 2;

    private List<CategoryModel> listCategories;

    public CategoryAdapter(List<CategoryModel> listCategories) {
        this.listCategories = listCategories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_CATEGORY_HORIZONTAL) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
            return new HorizontalViewHolder(inflate);
        } else if (viewType == TYPE_CATEGORY_VERTICAL) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category_vertical, parent, false);
            return new VerticalViewHolder(inflate);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CategoryModel categoryModel = listCategories.get(position);
        if (categoryModel == null) {
            return;
        }
        if (TYPE_CATEGORY_HORIZONTAL == holder.getItemViewType()) {
            HorizontalViewHolder horizontalViewHolder = (HorizontalViewHolder) holder;
            horizontalViewHolder.nameCategory.setText(categoryModel.getNameCategory());

            String url = categoryModel.getImgCategory();
            Glide
                    .with(horizontalViewHolder.itemView.getContext())
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.svg_img)
                    .into(horizontalViewHolder.imgCategory);

        } else if (TYPE_CATEGORY_HORIZONTAL == holder.getItemViewType()) {
            VerticalViewHolder verticalViewHolder = (VerticalViewHolder) holder;
            verticalViewHolder.nameCategoryVtc.setText(categoryModel.getNameCategory());

            String url = categoryModel.getImgCategory();
            Glide
                    .with(verticalViewHolder.itemView.getContext())
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.svg_img)
                    .into(verticalViewHolder.imgCategoryVtc);
        }

    }

    @Override
    public int getItemCount() {
        if (listCategories != null) {
            return listCategories.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        CategoryModel categoryModel = listCategories.get(position);
        if (categoryModel.isHorizontal()) {
            return TYPE_CATEGORY_HORIZONTAL;
        } else {
            return TYPE_CATEGORY_VERTICAL;
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout containerCategoryVtc;
        ImageView imgCategoryVtc;
        TextView nameCategoryVtc;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);

            containerCategoryVtc = itemView.findViewById(R.id.vh_category_vtc_container);
            imgCategoryVtc = itemView.findViewById(R.id.vh_category_vtc_img);
            nameCategoryVtc = itemView.findViewById(R.id.vh_category_vtc_name);
        }
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout containerCategory;
        ImageView imgCategory;
        TextView nameCategory;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);

            containerCategory = itemView.findViewById(R.id.vh_category_container);
            imgCategory = itemView.findViewById(R.id.vh_category_img);
            nameCategory = itemView.findViewById(R.id.vh_category_name);
        }
    }
}
