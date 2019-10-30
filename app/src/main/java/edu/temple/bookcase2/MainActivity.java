package edu.temple.bookcase2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements bookListFragment.listFragListener{
    boolean twoframes;
    private bookListFragment blf;
    private bookDetailsFragment bdf;
    private viewPagerFragment vpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoframes = (findViewById(R.id.bookdetails_fragment) != null);

        blf = bookListFragment.newInstance();
        vpa = viewPagerFragment.newInstance();

        if(twoframes) {
            bdf = bookDetailsFragment.newInstance();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.booklist_fragment, blf);
            ft.replace(R.id.bookdetails_fragment, bdf);
            ft.commit();
           // Toast.makeText(this, "Not reached here", Toast.LENGTH_SHORT).show();
        } else {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.booklist_fragment, vpa);
            ft.commit();
        }
    }

    @Override
    public void onInputListSent(String book) {
            bdf.updateTextView(book);
    }
}