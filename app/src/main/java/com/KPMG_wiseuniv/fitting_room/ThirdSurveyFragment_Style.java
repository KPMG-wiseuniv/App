package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ThirdSurveyFragment_Style extends ListFragment {

    ArrayList<ThirdSurveyStyleList> styles;
    ListView styleListView;
    private static ThirdSurveyStyleAdapter styleAdapter;

    Context context;
    MainActivity activity;
    String receiveData;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdSurveyFragment_Style() {
        // Required empty public constructor
    }

    public static ThirdSurveyFragment_Style newInstance() {
        return new ThirdSurveyFragment_Style();
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

        activity = (MainActivity) getActivity();
        receiveData = "";
    }

    // Send clicked style text
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //get Text
        String result = styles.get(position).getStyle();
        ((MainActivity)getActivity()).replaceFragment(ThirdSurveyFragment_Function.newInstance());

        Bundle bundle = new Bundle();
        bundle.putString("result", result);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_third_survey_style, container, false);

        // Add data and connect it to adapter
        styles = new ArrayList<>();
        styles.add(new ThirdSurveyStyleList("Modern", " This house mainly consists white, black and gray, with artificial finishes, smooth straight lines and curves.", R.drawable.style_modern));
        styles.add(new ThirdSurveyStyleList("Natural", " This house mainly consists bright brown, white, and beige colors, and has a natural texture that minimizes processing.", R.drawable.style_natural));
        styles.add(new ThirdSurveyStyleList("Northern Europe", " This house mainly consists light brown and white are the main colors, and has a natural texture such as wood, fabric, and artificial texture such as stainless steel.", R.drawable.style_northerneurope));
        styles.add(new ThirdSurveyStyleList("Vintage & Retro", " This house mainly consists of deep, dark colors such as dark green, dark brown, and black.  Antique wooden furniture and props are often used.", R.drawable.style_vintage_retro));
        styles.add(new ThirdSurveyStyleList("Minimal", " White and light gray are the main colors, minimizing props and decorations, and most of spaces are emptied by placing only necessary furniture.", R.drawable.style_minimalism));

        styleListView = (ListView) rootView.findViewById(android.R.id.list);
        styleAdapter = new ThirdSurveyStyleAdapter(getContext(), styles);
        styleListView.setAdapter(styleAdapter);


//        styleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            // TODO: style 전달
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////
////                ((MainActivity)getActivity()).replaceFragment(Fragment10.newInstance());
////            }
//
//        });


        return rootView;
    }

}