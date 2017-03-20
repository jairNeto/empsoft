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
    private List<Restaurant> RestaurantList;

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
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        List<Plates> plates = new ArrayList<>();
        plates.add(new Plates("Pizza de calabresa", 12, 4.5, 40));
        plates.add(new Plates("Torta de frango", 2, 4.75, 38));
        plates.add(new Plates("Pizza de frango", 12, 3.5, 45));
        plates.add(new Plates("Pizza doce", 12, 2.5, 39.90));
        plates.add(new Plates("Lasanha", 3, 4.5, 30));
        plates.add(new Plates("Pizza de frango", 12, 5, 45.50));
        plates.add(new Plates("Lasanha", 3, 4.5, 30));
        plates.add(new Plates("Torta de frango", 2, 4.75, 29.90));

        Restaurant a = new Restaurant("Restaurante1", 13, covers[0],plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante2", 8, covers[1], plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante3", 11, covers[2], plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante4", 12, covers[3], plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante5", 14, covers[4], plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante6", 5, covers[5], plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante7", 11, covers[6], plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante8", 10, covers[7],plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante9", 11, covers[8], plates);
        RestaurantList.add(a);

        a = new Restaurant("Restaurante10", 17, covers[9],plates);
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
}
