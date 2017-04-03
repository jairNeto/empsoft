package com.delaroystudios.MatchFood;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delaroystudios.MatchFood.adapter.RequestAdapter;
import com.delaroystudios.MatchFood.model.Order;
import com.delaroystudios.MatchFood.model.Request;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RequestAdapter newsListAdapter;
    private RecyclerView  recyclerView;
    private List<Order>   orders;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        List<Request> requests = getRequests();

        this.newsListAdapter = new RequestAdapter(this.getContext(), requests);

        this.recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        registerForContextMenu(recyclerView);
        this.recyclerView.setAdapter(newsListAdapter);
        this.recyclerView.setNestedScrollingEnabled(false);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(linearLayoutManager);

        return v;
    }

    private List<Request> getRequests() {
        int pizza = R.drawable.dominospizza;
        int user = R.drawable.user2;
        List<Request> requests = new ArrayList<>();
        requests.add(new Request("Pizza pequena", 2, pizza, user, 4.8, 25, 5));
        requests.add(new Request("Pizza média", 3, pizza, user, 4.8, 35, 5));
        requests.add(new Request("Pizza grande", 4, pizza, user, 4.8, 42, 5));
        requests.add(new Request("Pizza gigante", 5, pizza, user, 4.8, 48, 5));
        requests.add(new Request("Pizza especial", 5, pizza, user, 5.0, 55, 5));

        return requests;
    }

}
