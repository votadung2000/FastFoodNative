package com.example.fastfoodnative.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastfoodnative.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {
    FloatingActionButton fabOpen, fabClose, fabFavorite, fabCart, fabAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Mapping(view);
        ClickFabOpen();
        ClickFab();
        return view;
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
    }
}