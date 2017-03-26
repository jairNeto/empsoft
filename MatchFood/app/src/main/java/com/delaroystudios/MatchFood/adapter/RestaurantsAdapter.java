package com.delaroystudios.MatchFood.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.delaroystudios.MatchFood.DetailsActivity;
import com.delaroystudios.MatchFood.R;
import com.delaroystudios.MatchFood.model.Restaurant;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Restaurant> restaurantList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public RestaurantsAdapter(Context mContext, List<Restaurant> restaurantList) {
        this.mContext = mContext;
        this.restaurantList = restaurantList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Restaurant restaurant = restaurantList.get(position);
        holder.title.setText(restaurant.getName());

        Glide.with(mContext).load(restaurant.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext.getApplicationContext(), DetailsActivity.class);
                intent.putExtra("Restaurant", restaurant.getName());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
