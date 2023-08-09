package com.example.fastfoodnative.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fastfoodnative.R;
import com.example.fastfoodnative.activity.DetailProductActivity;
import com.example.fastfoodnative.model.ProductModel;

import java.text.DecimalFormat;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    List<ProductModel> listProducts;

    public ProductAdapter(List<ProductModel> listProducts) {
        this.listProducts = listProducts;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_product, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        ProductModel productModel = listProducts.get(position);
        if (productModel == null) {
            return;
        }

        holder.nameProduct.setText(productModel.getNameProduct());

        double convertNumber = Double.parseDouble(String.valueOf(productModel.getPriceProduct()));
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.priceProduct.setText(decimalFormat.format(convertNumber) + " VNĐ");

        String url = productModel.getImgProduct();
        Glide
                .with(holder.itemView.getContext())
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.svg_img)
                .into(holder.imgProduct);

        holder.cardProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailProductActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listProducts != null) {
            return listProducts.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardProduct;
        ImageView imgProduct;
        TextView nameProduct, priceProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardProduct = itemView.findViewById(R.id.vh_product_card_container);
            imgProduct = itemView.findViewById(R.id.vh_product_img);
            nameProduct = itemView.findViewById(R.id.vh_product_name);
            priceProduct = itemView.findViewById(R.id.vh_product_price);
        }
    }
}
