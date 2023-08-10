package com.example.fastfoodnative.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fastfoodnative.R;

public class CartFragment extends Fragment {
    ImageView imgBack;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_cart, container, false);

        Mapping(view);
        ClickBack(view);

        return view;
    }

    private void ClickBack(View view) {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    }

    private void Mapping(View view) {
        imgBack = view.findViewById(R.id.frag_cart_img_back);
    }
}