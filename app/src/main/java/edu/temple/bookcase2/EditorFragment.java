package edu.temple.bookcase2;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditorFragment extends Fragment {
    private static final String KEY_POSITION="position";

    static EditorFragment newInstance(int position) {
        EditorFragment frag=new EditorFragment();
        Bundle args=new Bundle();

        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);

        return(frag);
    }

    static String getTitle(String[] array, int position) {
        return array[position+1];
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_editor, container, false);
        int position=getArguments().getInt(KEY_POSITION, -1);
        String[] array = getResources().getStringArray(R.array.bookList);
        TextView textView = (TextView)result.findViewById(R.id.editorTextView);
        textView.setText(array[position]);
        return(result);
    }
}
