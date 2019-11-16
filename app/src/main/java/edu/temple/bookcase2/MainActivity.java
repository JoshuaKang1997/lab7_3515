package edu.temple.bookcase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import java.io.InputStreamReader;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;


public class MainActivity extends AppCompatActivity implements bookListFragment.listFragListener{
    boolean twoframes;
    private bookListFragment blf;
    private bookDetailsFragment bdf;
    private viewPagerFragment vpa;

    private JSONArray JSONbook;
    private String api = "https://kamorris.com/lab/audlib/booksearch.php";
    private String apiSearch = "https://kamorris.com/lab/audlib/booksearch.php?search=";



    Handler getBookHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            try {
                JSONbook = new JSONArray(msg.obj.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            initializeBook(JSONbook);
        }
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

        public void initializeBook(JSONArray js){
            if (js.length() > 0) {
                bookCollection.clear();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Can't find requested book",
                        Toast.LENGTH_LONG).show();
            }
            for (int i = 0; i < js.length(); i++){
                try {
                    JSONObject e = js.getJSONObject(i);

                    );
                    bookCollection.add(b);
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
        }

        @Override
        public void onBookSelected(int position) {
            currentDisplayedBook = position;
            BookDetailFragment fragment = (BookDetailFragment) getSupportFragmentManager().findFragmentByTag("bookDetailFragment");
            if (fragment != null) {

            }
            getSupportFragmentManager()
  
        }

    @Override
    public void onInputListSent(String book) {
            bdf.updateTextView(book);
    }
}