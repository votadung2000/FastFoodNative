package com.example.fastfoodnative.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fastfoodnative.R;
import com.example.fastfoodnative.adapter.CategoryAdapter;
import com.example.fastfoodnative.adapter.ProductAdapter;
import com.example.fastfoodnative.model.CategoryModel;
import com.example.fastfoodnative.model.ProductModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FloatingActionButton fabOpen, fabClose, fabFavorite, fabCart, fabAccount;

    private RecyclerView rccViewCategories, rccViewProducts;
    private RecyclerView.Adapter adapterCategory, adapterProduct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Mapping(view);
        ClickFabOpen();
        ClickFab();
        recyclerViewCategoryList(view);
        recyclerViewProductList(view);
        return view;
    }

    private void recyclerViewProductList(View view) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        rccViewProducts.setLayoutManager(gridLayoutManager);

        ArrayList<ProductModel> products = new ArrayList<>();

        products.add(new ProductModel(1, "name 1", 1, "", "", 100000, 0));
        products.add(new ProductModel(2, "name 2", 1, "", "", 100000, 0));
        products.add(new ProductModel(3, "name 3", 1, "", "", 100000, 0));
        products.add(new ProductModel(4, "name 4", 1, "", "", 100000, 0));
        products.add(new ProductModel(5, "name 5", 1, "", "", 100000, 0));
        products.add(new ProductModel(6, "name 6", 1, "", "", 100000, 0));
        products.add(new ProductModel(7, "name 7", 1, "", "", 100000, 0));

        adapterProduct = new ProductAdapter(products);
        rccViewProducts.setAdapter(adapterProduct);
    }

    private void recyclerViewCategoryList(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rccViewCategories.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel(1, "name 1", 1, ""));
        categories.add(new CategoryModel(2, "name 2", 1, ""));
        categories.add(new CategoryModel(3, "name 3", 1, ""));
        categories.add(new CategoryModel(4, "name 4", 1, ""));
        categories.add(new CategoryModel(5, "name 5", 1, ""));
        categories.add(new CategoryModel(6, "name 6", 1, ""));
        categories.add(new CategoryModel(7, "name 7", 1, ""));

        adapterCategory = new CategoryAdapter(categories);
        rccViewCategories.setAdapter(adapterCategory);
    }

    private void ClickFabOpen() {
        fabOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayFabBtn();
            }
        });
    }

    private void ClickFab() {
        fabClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HideFabBtn();
            }
        });
    }

    private void DisplayFabBtn() {
        fabClose.show();
        fabFavorite.show();
        fabCart.show();
        fabAccount.show();

        fabOpen.hide();
    }

    private void HideFabBtn() {
        fabClose.hide();
        fabFavorite.hide();
        fabCart.hide();
        fabAccount.hide();

        fabOpen.show();
    }

    private void Mapping(View view) {
        fabOpen = view.findViewById(R.id.fab_open);
        fabClose = view.findViewById(R.id.fab_close);
        fabFavorite = view.findViewById(R.id.fab_favorite);
        fabCart = view.findViewById(R.id.fab_cart);
        fabAccount = view.findViewById(R.id.fab_account);

        rccViewCategories = view.findViewById(R.id.frag_home_rccView_Categories);
        rccViewProducts = view.findViewById(R.id.frag_home_rccView_Products);
    }
}