package com.delaroystudios.MatchFood;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delaroystudios.MatchFood.adapter.PlatesAdapter;
import com.delaroystudios.MatchFood.model.Order;
import com.delaroystudios.MatchFood.model.Plate;

import java.util.List;

public class HomeFragment extends Fragment {

    private PlatesAdapter newsListAdapter;
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
