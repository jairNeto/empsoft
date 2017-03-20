package com.delaroystudios.MatchFood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String data   = extras.getString("Restaurant");
        int options   = extras.getInt("Options");
        int thumbnail = extras.getInt("Picture");

        TextView textView = (TextView)findViewById(R.id.restaurant_name);
        textView.setText(data);

        ImageView imageView = (ImageView)findViewById(R.id.thumbnail);
        Glide.with(getApplicationContext()).load(thumbnail).into(imageView);
    }
}
