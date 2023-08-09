package com.example.fastfoodnative.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fastfoodnative.R;
import com.example.fastfoodnative.activity.DetailProductActivity;
import com.example.fastfoodnative.model.ProductFavoriteModel;

import java.text.DecimalFormat;
import java.util.List;

public class ProductFavoriteAdapter extends RecyclerView.Adapter<ProductFavoriteAdapter.ViewHolder> {
    private List<ProductFavoriteModel> listProducts;

    public ProductFavoriteAdapter(List<ProductFavoriteModel> listProducts) {
        this.listProducts = listProducts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_product_favorite, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductFavoriteModel productModel = listProducts.get(position);
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
        TextView nameProduct, priceProduct;
        ImageView imgProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardProduct = itemView.findViewById(R.id.vh_favorite_card);
            nameProduct = itemView.findViewById(R.id.vh_favorite_name);
            priceProduct = itemView.findViewById(R.id.vh_favorite_price);
            imgProduct = itemView.findViewById(R.id.vh_favorite_img);
        }
    }
}
