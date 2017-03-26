package com.delaroystudios.MatchFood.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delaroystudios.MatchFood.R;
import com.delaroystudios.MatchFood.model.Plates;

import java.util.List;

/**
 * Created by Lucas on 20/03/2017.
 */

public class PlatesAdapter extends RecyclerView.Adapter<PlatesAdapter.MyViewHolder>{
    private Context context;
    private List<Plates> plates;

    public PlatesAdapter(Context context, List<Plates> platesRestaurant){
        this.context = context;
        this.plates = platesRestaurant;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.plate_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Plates plate = plates.get(position);

        holder.rating.setRating((float) plate.getEvaluation());
        holder.name.setText(plate.getName());
        holder.amount.setText(plate.getAmount() + " pessoas. Preço: " + plate.getPrice() + "R$");

        Glide.with(context).load(plate.getThumbnail()).into(holder.picture);

        holder.comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu();
            }
        });
    }

    @Override
    public int getItemCount() {
        return plates.size();
    }

    public void update(List<Plates> plates) {
        this.plates = plates;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private TextView amount;
        private ImageView picture;
        private RatingBar rating;
        private TextView comprar;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.amount = (TextView) itemView.findViewById(R.id.amount);
            this.picture = (ImageView) itemView.findViewById(R.id.picture);
            this.rating = (RatingBar) itemView.findViewById(R.id.rating);

            comprar = (TextView) itemView.findViewById(R.id.comprar);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

    private void showPopupMenu() {
        Dialog dialog = new Dialog(context, android.R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alert);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.getWindow().setLayout(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
