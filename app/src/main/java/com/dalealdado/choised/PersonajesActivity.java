package com.dalealdado.choised;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.dalealdado.choised.view.EnemigosNewActivity;
import com.dalealdado.choised.view.HeroesNewActivity;
import com.dalealdado.dalealdado.R;

public class PersonajesActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private DADViewModel enemigosViewModel;
    private DADViewModel heroesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonajesActivity.this, HeroesNewActivity.class));
            }
        });

        findViewById(R.id.adde).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonajesActivity.this, EnemigosNewActivity.class));
            }
        });

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        heroesViewModel = ViewModelProviders.of(PersonajesActivity.this).get(DADViewModel.class);
        enemigosViewModel = ViewModelProviders.of(PersonajesActivity.this).get(DADViewModel.class);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new HeroesListFragment();
                case 1: return new EnemigosListFragments();
                default: return new HeroesListFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
