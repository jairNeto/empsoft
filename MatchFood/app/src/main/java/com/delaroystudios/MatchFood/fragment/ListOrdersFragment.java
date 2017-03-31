package com.delaroystudios.MatchFood.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delaroystudios.MatchFood.DividerItemDecoration;
import com.delaroystudios.MatchFood.R;
import com.delaroystudios.MatchFood.adapter.OrdersAdapter;
import com.delaroystudios.MatchFood.model.Order;

import java.util.ArrayList;
import java.util.List;

public class ListOrdersFragment extends Fragment {
    private List<Order> orders = new ArrayList();
    private RecyclerView recyclerView;
    private OrdersAdapter ordersAdapter;
    public ListOrdersFragment(){

    }

    public ListOrdersFragment(List<Order> orders) {
        // Required empty public constructor
        this.orders = orders;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_list_orders, container, false);

        this.ordersAdapter = new OrdersAdapter(getContext(), orders);

        this.recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        registerForContextMenu(recyclerView);
        this.recyclerView.setAdapter(ordersAdapter);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(linearLayoutManager);

        ordersAdapter.update(orders);
        return v;
    }
}
