package edu.temple.bookcase2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerAdapter extends FragmentPagerAdapter {
    Context context = null;

    public viewPagerAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = ctxt;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Fragment getItem(int position) {
        return (EditorFragment.newInstance(position));
    }

    public String getPageTitle(int position) {
        String[] array = {"Harry Potter",
                "Binging With Babish",
                "Percy Jackson",
                "Kama Sutra",
                "50 Shades of Grey",
                "Bible",
                "Bible 2",
                "Green Eggs and Ham",
                "How to Read",
                "Bible 3"};
        return (EditorFragment.getTitle(array, position));
    }
}
