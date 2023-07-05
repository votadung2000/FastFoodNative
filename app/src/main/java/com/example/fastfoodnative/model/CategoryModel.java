package com.example.fastfoodnative.model;

public class CategoryModel {
    int idCategory;
    String nameCategory;
    int statusCategory;
    String imgCategory;

    public CategoryModel(int idCategory, String nameCategory, int statusCategory, String imgCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory.isEmpty() ? "" : nameCategory;
        this.statusCategory = statusCategory;
        this.imgCategory = imgCategory.isEmpty() ? "" : imgCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(int statusCategory) {
        this.statusCategory = statusCategory;
    }

    public String getImgCategory() {
        return imgCategory;
    }

    public void setImgCategory(String imgCategory) {
        this.imgCategory = imgCategory;
    }
}
