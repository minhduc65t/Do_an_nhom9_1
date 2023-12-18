package com.example.do_an_nhom9.HomeAdapter;

import android.graphics.drawable.Drawable;

public class CategoriesHelper {
    Drawable gradient;
    int image;
    String title;

    public CategoriesHelper(Drawable gradient, int image, String title) {
        this.gradient = gradient;
        this.image = image;
        this.title = title;
    }

    public Drawable getGradient() {
        return gradient;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
