package com.delaroystudios.MatchFood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delaroystudios.MatchFood.adapter.PlatesAdapter;
import com.delaroystudios.MatchFood.model.Plates;
import com.delaroystudios.MatchFood.model.Restaurant;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private PlatesAdapter newsListAdapter;
    private RecyclerView  recyclerView;
    private Restaurant    restaurant;
    private List<Plates>  plates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        List<Restaurant> restaurants = MainActivity.getRestaurantList();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("Restaurant");

        for(int i = 0; i < restaurants.size(); i++)
        {
            if (restaurants.get(i).getName().equals(name))
            {
                restaurant = restaurants.get(i);
                plates = restaurant.getPlates();
                break;
            }
        }


        TextView textView = (TextView)findViewById(R.id.restaurant_name);
        textView.setText("Restaurante " + restaurant.getName());

        EditText search = (EditText) findViewById(R.id.search);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().equals("")){
                    plates = restaurant.getPlates();
                }
                else{
                    //searchPlate(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        ImageView imageView = (ImageView)findViewById(R.id.image);
        Glide.with(getApplicationContext()).load(restaurant.getThumbnail()).into(imageView);

        this.newsListAdapter = new PlatesAdapter(this, plates);

        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        registerForContextMenu(recyclerView);
        this.recyclerView.setAdapter(newsListAdapter);
        this.recyclerView.setNestedScrollingEnabled(false);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(linearLayoutManager);

        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        int valueMultiplier = (int) ((height - 888) * 0.10) + 124;

        recyclerView.getLayoutParams().height = valueMultiplier * restaurant.getPlates().size();
        FrameLayout y = (FrameLayout) findViewById(R.id.frameLayout);
        y.requestFocus();
    }

}
