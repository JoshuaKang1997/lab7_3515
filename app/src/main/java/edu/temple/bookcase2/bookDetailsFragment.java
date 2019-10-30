package edu.temple.bookcase2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class bookDetailsFragment extends Fragment {
  //  private detailFragListener listener;
    private TextView textView;

    public static bookDetailsFragment newInstance() {
        bookDetailsFragment fragment = new bookDetailsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_details, container, false);
        textView = view.findViewById(R.id.textViewID);
        return view;
    }

    public void updateTextView(String book) {
        textView.setText(book);
    }
}
