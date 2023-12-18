package com.example.do_an_nhom9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.do_an_nhom9.HomeAdapter.FeaturedAdapter;
import com.example.do_an_nhom9.HomeAdapter.FeaturedHelper;
import com.example.do_an_nhom9.HomeAdapter.CategoriesAdapter;
import com.example.do_an_nhom9.HomeAdapter.CategoriesHelper;
import com.example.do_an_nhom9.HomeAdapter.MostViewedAdapter;
import com.example.do_an_nhom9.HomeAdapter.MostViewedHelper;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;

    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);

        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelper> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelper(R.drawable.a,"Exchange","asdas das dasd asdas"));
        featuredLocations.add(new FeaturedHelper(R.drawable.b,"Group","asdas das dasd asdas"));
        featuredLocations.add(new FeaturedHelper(R.drawable.c,"News","asdas das dasd asdas"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradient1 =  new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});
    }
    private void categoriesRecycler() {
        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        ArrayList<CategoriesHelper> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelper(gradient1, R.drawable.e, "Education"));
        categoriesHelperClasses.add(new CategoriesHelper(gradient2, R.drawable.f, "HOSPITAL"));
        categoriesHelperClasses.add(new CategoriesHelper(gradient3, R.drawable.g, "Restaurant"));
        categoriesHelperClasses.add(new CategoriesHelper(gradient4, R.drawable.h, "Shopping"));
        categoriesHelperClasses.add(new CategoriesHelper(gradient1, R.drawable.i, "Transport"));
        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }
    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelper> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelper(R.drawable.a, "McDonald's"));
        mostViewedLocations.add(new MostViewedHelper(R.drawable.b, "Education"));
        mostViewedLocations.add(new MostViewedHelper(R.drawable.c, "J."));
        mostViewedLocations.add(new MostViewedHelper(R.drawable.d, "Walmart"));
        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViewedRecycler.setAdapter(adapter);
    }
}