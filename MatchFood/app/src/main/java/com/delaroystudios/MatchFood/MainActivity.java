package com.delaroystudios.MatchFood;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.delaroystudios.MatchFood.adapter.RestaurantsAdapter;
import com.delaroystudios.MatchFood.model.Plate;
import com.delaroystudios.MatchFood.model.Restaurant;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Fragment{

    private RecyclerView recyclerView;
    private RestaurantsAdapter adapter;
    private static List<Restaurant> RestaurantList;

    public MainActivity(){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Toast.makeText(getContext(), "Bem vindo " + ParseUser.getCurrentUser().getUsername(), Toast.LENGTH_LONG).show();

        View v =  inflater.inflate(R.layout.activity_main, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        RestaurantList = new ArrayList<>();
        adapter = new RestaurantsAdapter(getContext(), RestaurantList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();
        return v;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.amaranto,
                R.drawable.bar,
                R.drawable.camaroes,
                R.drawable.dominos2,
                R.drawable.galicia,
                R.drawable.tasca,

        };

        int plate = R.drawable.plate;

        List<Plate> plates = new ArrayList<>();
        plates.add(new Plate("Bacalhau da Tasca", 12, 4.5, 40, plate));
        plates.add(new Plate("Arroz de Pato", 2, 4.75, 38, plate));
        plates.add(new Plate("Bacalhau Lagreiro", 12, 3.5, 45, plate));
        plates.add(new Plate("Arroz de Braga", 4, 2.5, 39.90, plate));
        plates.add(new Plate("Medalhão Funghi", 3, 4.5, 30, plate));
        plates.add(new Plate("Posta de bacalhau", 2, 5, 35.50, plate));

        Restaurant a = new Restaurant("Amaranto", covers[0], getAmarantoPlates());
        RestaurantList.add(a);

        a = new Restaurant("Bar do Cuscuz", covers[1], getBDCPlates());
        RestaurantList.add(a);

        a = new Restaurant("Camarões", covers[2], getBDCPlates());
        RestaurantList.add(a);

        a = new Restaurant("Domino's", covers[3], getDominosPlates());
        RestaurantList.add(a);

        a = new Restaurant("Galícia", covers[4], getAmarantoPlates());
        RestaurantList.add(a);

        a = new Restaurant("Tasca do Arouche", covers[5], plates);
        RestaurantList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private List<Plate> getAmarantoPlates() {
        List<Plate> plates = new ArrayList<>();
        plates.add(new Plate("Salada Amaranto", 2, 4.5, 40, R.drawable.amaranto_vila1));
        plates.add(new Plate("Nchoque Bolonhesa", 2, 4.75, 45, R.drawable.amarantovila2));
        plates.add(new Plate("Escalope de Salmão", 3, 3.5, 90, R.drawable.amarantovila3));
        plates.add(new Plate("Filé 4 estações", 3, 2.5, 85, R.drawable.amarantovila4));
        plates.add(new Plate("Surpresa de morango", 2, 4.5, 28, R.drawable.amarantovila5));
        return plates;
    }

    private List<Plate> getBDCPlates() {
        int plate = R.drawable.plate;
        List<Plate> plates = new ArrayList<>();
        plates.add(new Plate("Carne de Sol na nata", 3, 4.8, 50, R.drawable.carnedesolcomnata));
        plates.add(new Plate("Frango na chapa", 3, 4.25, 45, R.drawable.frangogrelhada));
        plates.add(new Plate("Galinha Guisada", 3, 3.5, 45, R.drawable.galinhaguisada));
        plates.add(new Plate("Picanha", 4, 5.5, 95, R.drawable.picanha));
        plates.add(new Plate("Sinfonia", 2, 4.5, 60, plate));
        return plates;
    }

    private List<Plate> getDominosPlates() {
        int pizza = R.drawable.dominospizza;
        List<Plate> plates = new ArrayList<>();
        plates.add(new Plate("Pizza pequena", 2, 4.8, 25, pizza));
        plates.add(new Plate("Pizza média", 3, 4.8, 35, pizza));
        plates.add(new Plate("Pizza grande", 4, 4.8, 42, pizza));
        plates.add(new Plate("Pizza gigante", 5, 4.8, 48, pizza));
        plates.add(new Plate("Pizza gigante especial", 2, 5.0, 55, pizza));

        return plates;
    }

    public static List<Restaurant> getRestaurantList()
    {
        return RestaurantList;
    }
}