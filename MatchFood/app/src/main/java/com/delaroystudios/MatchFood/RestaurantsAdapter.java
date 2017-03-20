package com.delaroystudios.MatchFood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Restaurant> restaurantList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
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
        holder.count.setText(restaurant.getOptions() + " opções");

        // loading album cover using Glide library
        Glide.with(mContext).load(restaurant.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow, restaurant);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view, final Restaurant restaurant) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        final MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_add_favourite:
                        Toast.makeText(mContext, "Adicionado aos favoritos", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_details:
                        Intent intent = new Intent(mContext.getApplicationContext(), DetailsActivity.class);
                        intent.putExtra("Restaurant", restaurant.getName());
                        intent.putExtra("Options", restaurant.getOptions());
                        intent.putExtra("Picture", restaurant.getThumbnail());
                        mContext.startActivity(intent);
                        return true;
                    default:
                }
                return false;
            }
        });
        popup.show();
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
