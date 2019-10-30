package edu.temple.bookcase2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class viewPagerFragment extends Fragment {

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

        return view;
    }
    private PagerAdapter buildAdapter() {
        return(new viewPagerAdapter(getActivity(), getChildFragmentManager()));
    }
}

