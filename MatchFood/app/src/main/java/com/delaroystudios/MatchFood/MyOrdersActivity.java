package com.delaroystudios.MatchFood;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.delaroystudios.MatchFood.fragment.ListOrdersFragment;
import com.delaroystudios.MatchFood.model.Order;
import com.delaroystudios.MatchFood.model.Plates;
import com.delaroystudios.MatchFood.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" Pedidos");
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setText("COMPRADOS");
        tabLayout.getTabAt(1).setText("EM ESPERA");
        tabLayout.getTabAt(2).setText("FINALIZADO");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        List<Order> orders = new ArrayList<>();

        //TESTE
        int plate = R.drawable.plate;
        List<Plates> plates = new ArrayList<>();
        plates.add(new Plates("Camarão ao Thermidor", 12, 4.5, 40, plate));
        plates.add(new Plates("Risoto de Bacalhau", 2, 4.75, 38, plate));
        plates.add(new Plates("Carne de Sol na nata", 12, 3.5, 45, plate));
        plates.add(new Plates("Prato 4", 12, 2.5, 39.90, plate));
        plates.add(new Plates("Prato 5", 3, 4.5, 30, plate));
        plates.add(new Plates("Prato 6", 12, 5, 45.50, plate));

        Restaurant a = new Restaurant("Amaranto",R.drawable.amaranto, plates);
        Restaurant b = new Restaurant("Camarões",R.drawable.camaroes, plates);
        Restaurant c = new Restaurant("Bar do Cuscuz",R.drawable.bar, plates);
        //
        orders.add(new Order(b,plates.get(1),"30 de abril de 2017 - as 18:30h"));
        orders.add(new Order(a,plates.get(0),"30 de abril de 2017 - as 18:30h"));
        orders.add(new Order(c,plates.get(2),"30 de abril de 2017 - as 12:30h"));

        adapter.addFragment(new ListOrdersFragment(orders), "ONE");
        List<Order> orders2 = new ArrayList<>();
        orders2.addAll(orders);
        orders2.remove(0);
        adapter.addFragment(new ListOrdersFragment(orders2), "TWO");
        adapter.addFragment(new ListOrdersFragment(orders), "THREE");
        viewPager.setAdapter(adapter);
    }

    // Tabs
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
