package edu.temple.bookcase2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerAdapter extends FragmentPagerAdapter {
    Context context=null;

    public viewPagerAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = ctxt;
    }

    @Override
    public int getCount() {
        return 10;
    }
    @Override
    public Fragment getItem(int position) {
        return(EditorFragment.newInstance(position));
    }

    public String getPageTitle(int position) {
        return(EditorFragment.getTitle(ctxt, position));
    }
}
