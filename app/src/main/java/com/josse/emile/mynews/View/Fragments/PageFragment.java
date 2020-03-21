package com.josse.emile.mynews.View.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.josse.emile.mynews.View.Adapter.RecyclerViewAdapter;
import com.josse.emile.mynews.R;

import java.util.ArrayList;


public class PageFragment extends Fragment {


    private TextView mTextView;
    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mImagesUrl = new ArrayList<>();
    private ArrayList<String> mArticleUrl = new ArrayList<>();


    public PageFragment() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_page,container, false);
        mTextView = view.findViewById(R.id.fragment_page_title);

        int position = getArguments().getInt("pos");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        //initAriclesArray(recyclerView,getContext());
        // TODO changer ce test pour chaque page dans le switch en dessous


        switch(position){
            case 1: mTextView.setText("blap");//recycler view here top stories
                initAriclesArray(recyclerView,getContext(),"https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg", "blap");
                break;
           case 2: mTextView.setText("blub");//recycler view here most popular
               initAriclesArray(recyclerView,getContext(),"https://i.redd.it/tpsnoz5bzo501.jpg","blub");
                break;
            default: mTextView.setText("gawap");//recycler view custom
                initAriclesArray(recyclerView,getContext(),"https://static01.nyt.com/images/2020/01/09/video/xxivid-iran-plane-2/xxivid-iran-plane-2-thumbStandard.jpg","gawap");
                break;
        }
        mTextView.setTextColor(Color.RED);

        return view;
    }

    private void initAriclesArray(RecyclerView view, Context context, String imageUrl, String articleTitle){

        int i = 0;
        while (i < 20){
            mImagesUrl.add(imageUrl);
            mTitle.add(articleTitle);
            i++;
        }

        initRecyclerView(view, context);

    }

    private void initRecyclerView(RecyclerView view, Context context){
        RecyclerView recyclerView =  view;
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitle, mImagesUrl, context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }



}
