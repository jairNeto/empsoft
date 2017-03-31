package com.delaroystudios.MatchFood.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delaroystudios.MatchFood.R;
import com.delaroystudios.MatchFood.model.Order;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder>{
    private Context context;
    private List<Order> orders;

    public OrdersAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_card, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        Order order = orders.get(position);

      //  holder.name.setText(order.getRestaurant().getName() + "");
      //  holder.date.setText(order.getDate() + "");
      //  holder.plate.setText(order.getPlate().getName() + "");

      //  Glide.with(context).load(order.getRestaurant().getThumbnail()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }


    public void update(List<Order> list) {
        this.orders = list;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView name;
        private TextView plate;
        private ImageView image;

        public viewHolder(View itemView) {
            super(itemView);

            this.date = (TextView) itemView.findViewById(R.id.date);
            this.name = (TextView) itemView.findViewById(R.id.restaurant_name);
            this.plate = (TextView) itemView.findViewById(R.id.home);
            this.image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
