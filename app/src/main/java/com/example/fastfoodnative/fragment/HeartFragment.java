package com.example.fastfoodnative.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fastfoodnative.R;
import com.example.fastfoodnative.adapter.CategoryAdapter;
import com.example.fastfoodnative.model.CategoryModel;

import java.util.ArrayList;

public class HeartFragment extends Fragment {
    private RecyclerView rccViewCategories;
    private RecyclerView.Adapter adapterCategory;

    private ImageView imgBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heart, container, false);

        Mapping(view);
        recyclerViewCategoryList(view);

        ClickBack();

        return view;
    }

    private void ClickBack() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    }

    private void recyclerViewCategoryList(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        rccViewCategories.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel(1, "name 1", 1, "", false));
        categories.add(new CategoryModel(2, "name 2", 1, "", false));
        categories.add(new CategoryModel(3, "name 3", 1, "", false));
        categories.add(new CategoryModel(4, "name 4", 1, "", false));
        categories.add(new CategoryModel(5, "name 5", 1, "", false));
        categories.add(new CategoryModel(6, "name 6", 1, "", false));
        categories.add(new CategoryModel(7, "name 7", 1, "", false));

        adapterCategory = new CategoryAdapter(categories);
        rccViewCategories.setAdapter(adapterCategory);
    }

    private void Mapping(View view) {
        rccViewCategories = view.findViewById(R.id.frag_heart_rccView_categories);

        imgBack = view.findViewById(R.id.frag_heart_img_back);
    }
}