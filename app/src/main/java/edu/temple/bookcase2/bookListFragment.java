package edu.temple.bookcase2;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class bookListFragment extends Fragment {
     private listFragListener listener;

    public static bookListFragment newInstance() {
        bookListFragment fragment = new bookListFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    public interface listFragListener {
        void onInputListSent(String book);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        Resources resourses = getContext().getResources();
        final String[] booklist = resourses.getStringArray(R.array.bookList);
        Context context = getActivity();

        ListView listView = (ListView) view.findViewById(R.id.listViewID);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item,
                booklist);

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String book = booklist[position];
                listener.onInputListSent(book);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof listFragListener) {
            listener = (listFragListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement listFragListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}