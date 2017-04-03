package com.delaroystudios.MatchFood.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delaroystudios.MatchFood.R;
import com.delaroystudios.MatchFood.model.Request;

import java.util.List;

/**
 * Created by jairneto on 2/4/17.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder>{
    private Context context;
    private List<Request> requests;
    private Handler mHandler = new Handler();

    public RequestAdapter(Context context, List<Request> requests){
        this.context = context;
        this.requests = requests;
    }

    @Override
    public RequestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.request_card, parent, false);
        return new RequestAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RequestAdapter.MyViewHolder holder, int position) {
        Request request = requests.get(position);

        holder.plateRating.setRating((float) request.getPlateEvaluation());
        holder.name.setText(request.getName());
        holder.amount.setText(request.getAmount() + " pessoas. Preço: R$" + request.getPrice() + "");
//        holder.userRating.setRating((float) request.getUserEvaluation());

        Glide.with(context).load(request.getUserThumbnail()).into(holder.userPicture);
        Glide.with(context).load(request.getPlateThumbnail()).into(holder.platePicture);

    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    public void update(List<Request> requests) {
        this.requests = requests;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private TextView amount;
        private ImageView platePicture;
        private RatingBar plateRating;
        private RatingBar userRating;
        private ImageView userPicture;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.amount = (TextView) itemView.findViewById(R.id.amount);
            this.platePicture = (ImageView) itemView.findViewById(R.id.plate_picture);
            this.plateRating = (RatingBar) itemView.findViewById(R.id.plate_rating);
            this.userPicture = (ImageView) itemView.findViewById(R.id.user_picture);
            //this.userRating = (RatingBar) itemView.findViewById(R.id.user_rating);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

}
