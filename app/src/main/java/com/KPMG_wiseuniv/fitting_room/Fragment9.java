package com.KPMG_wiseuniv.fitting_room;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment9#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment9 extends Fragment {

    ArrayList<SingleStyle> styles;
    ListView styleListView;
    private static StyleAdapter styleAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment9() {
        // Required empty public constructor
    }

    public static Fragment9 newInstance() {
        return new Fragment9();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_9, container, false);

        //data 가져와서 adapter와 연결
        styles = new ArrayList<>();
        styles.add(new SingleStyle("Modern", " This house mainly consists white, black and gray, with artificial finishes, smooth straight lines and curves.", R.drawable.style_modern));
        styles.add(new SingleStyle("Natural", " This house mainly consists bright brown, white, and beige colors, and has a natural texture that minimizes processing.", R.drawable.style_natural));
        styles.add(new SingleStyle("Northern Europe", " This house mainly consists light brown and white are the main colors, and has a natural texture such as wood, fabric, and artificial texture such as stainless steel.", R.drawable.style_northerneurope));
        styles.add(new SingleStyle("Vintage & Retro", " This house mainly consists of deep, dark colors such as dark green, dark brown, and black.  Antique wooden furniture and props are often used.", R.drawable.style_vintage_retro));
        styles.add(new SingleStyle("Minimal", " White and light gray are the main colors, minimizing props and decorations, and most of spaces are emptied by placing only necessary furniture.", R.drawable.style_minimalism));

        styleListView = (ListView) rootView.findViewById(R.id.listView_style);
        styleAdapter = new StyleAdapter(getContext(), styles);
        styleListView.setAdapter(styleAdapter);
        styleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // TODO: style 전달
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity)getActivity()).replaceFragment(Fragment10.newInstance());
            }

        });



        return rootView;
    }
}