package com.delaroystudios.MatchFood;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.delaroystudios.MatchFood.adapter.RestaurantsAdapter;
import com.delaroystudios.MatchFood.model.Plates;
import com.delaroystudios.MatchFood.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RestaurantsAdapter adapter;
    private static List<Restaurant> RestaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RestaurantList = new ArrayList<>();
        adapter = new RestaurantsAdapter(this, RestaurantList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.amaranto,
                R.drawable.bar,
                R.drawable.camaroes,
                R.drawable.galicia,
                R.drawable.casona,
                R.drawable.tasca,
        };

        int plate = R.drawable.plate;

        List<Plates> plates = new ArrayList<>();
        plates.add(new Plates("Prato 1", 12, 4.5, 40, plate));
        plates.add(new Plates("Prato 2", 2, 4.75, 38, plate));
        plates.add(new Plates("Prato 3", 12, 3.5, 45, plate));
        plates.add(new Plates("Prato 4", 12, 2.5, 39.90, plate));
        plates.add(new Plates("Prato 5", 3, 4.5, 30, plate));
        plates.add(new Plates("Prato 6", 12, 5, 45.50, plate));

        Restaurant a = new Restaurant("Amaranto", covers[0], plates);
        RestaurantList.add(a);

        a = new Restaurant("Bar do Cuscuz", covers[1], plates);
        RestaurantList.add(a);

        a = new Restaurant("Camarões", covers[2], plates);
        RestaurantList.add(a);

        a = new Restaurant("Galícia", covers[3], plates);
        RestaurantList.add(a);

        a = new Restaurant("La Casona", covers[4], plates);
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

    public static List<Restaurant> getRestaurantList()
    {
        return RestaurantList;
    }
}
