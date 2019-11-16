package edu.temple.bookcase2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class viewPagerFragment extends Fragment {

    private int current;

    public static viewPagerFragment newInstance() {
        viewPagerFragment fragment = new viewPagerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        ViewPager pager=(ViewPager)view.findViewById(R.id.pager);
        pager.setAdapter(buildAdapter());
        pager.setCurrentItem(current,true);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionoffsetPixels) {

            }


            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }
    private PagerAdapter buildAdapter() {
        return(new viewPagerAdapter(getActivity(), getChildFragmentManager(),getResources().getStringArray(R.array.bookList)));
    }
}

