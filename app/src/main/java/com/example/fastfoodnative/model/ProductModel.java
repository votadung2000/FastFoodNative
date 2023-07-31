package com.example.fastfoodnative.model;

public class ProductModel {
    int idProduct;
    String nameProduct;
    int statusProduct;
    String imgProduct;
    String tasteProduct;
    int priceProduct;
    int discountProduct;

    public ProductModel(int idProduct, String nameProduct, int statusProduct, String imgProduct, String tasteProduct, int priceProduct, int discountProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct.isEmpty() ? "" : nameProduct;
        this.statusProduct = statusProduct;
        this.imgProduct = imgProduct.isEmpty() ? "" : imgProduct;
        this.tasteProduct = tasteProduct;
        this.priceProduct = priceProduct;
        this.discountProduct = discountProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(int statusProduct) {
        this.statusProduct = statusProduct;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getTasteProduct() {
        return tasteProduct;
    }

    public void setTasteProduct(String tasteProduct) {
        this.tasteProduct = tasteProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getDiscountProduct() {
        return discountProduct;
    }

    public void setDiscountProduct(int discountProduct) {
        this.discountProduct = discountProduct;
    }
}
