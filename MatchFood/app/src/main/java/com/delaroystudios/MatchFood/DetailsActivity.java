package com.delaroystudios.MatchFood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delaroystudios.MatchFood.adapter.PlatesAdapter;
import com.delaroystudios.MatchFood.model.Plates;
import com.delaroystudios.MatchFood.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private PlatesAdapter newsListAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Restaurant restaurant = (Restaurant) extras.get("Restaurant");

        TextView textView = (TextView)findViewById(R.id.restaurant_name);
        textView.setText(restaurant.getName());

        ImageView imageView = (ImageView)findViewById(R.id.image_restaurant);
        Glide.with(getApplicationContext()).load(R.drawable.album3).into(imageView);


        this.newsListAdapter = new PlatesAdapter(this, restaurant.getPlates());
        ScrollView scroll = (ScrollView) findViewById(R.id.scroll);

        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        registerForContextMenu(recyclerView);
        this.recyclerView.setAdapter(newsListAdapter);
        this.recyclerView.setNestedScrollingEnabled(false);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(linearLayoutManager);


        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        double wi = (double) width / (double) dm.xdpi;
        double hi = (double) height / (double) dm.ydpi;
        double x1 = Math.pow(wi, 2);
        double y1 = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x1 + y1);

        int valueMultiplier = (int) ((height - 888) * 0.10) + 124;

        List<Plates> plates = new ArrayList<>();
        plates.add(new Plates("Pizza de calabresa", 12, 4.5, 40));
        plates.add(new Plates("Torta de frango", 2, 4.75, 38));
        plates.add(new Plates("Pizza de frango", 12, 3.5, 45));
        plates.add(new Plates("Pizza doce", 12, 2.5, 39.90));
        plates.add(new Plates("Lasanha", 3, 4.5, 30));
        plates.add(new Plates("Pizza de frango", 12, 5, 45.50));
        plates.add(new Plates("Lasanha", 3, 2.5, 30));
        plates.add(new Plates("Torta de frango", 2, 4.75, 29.90));
        restaurant.setPlates(plates);
        recyclerView.getLayoutParams().height = valueMultiplier * restaurant.getPlates().size();
        newsListAdapter.update(restaurant.getPlates());

        FrameLayout y = (FrameLayout) findViewById(R.id.frameLayout);
        y.requestFocus();
    }
}
