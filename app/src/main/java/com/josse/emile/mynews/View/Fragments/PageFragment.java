package com.josse.emile.mynews.View.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.josse.emile.mynews.Model.POJOS.ArticlePojo;
import com.josse.emile.mynews.Model.DAO;
import com.josse.emile.mynews.View.Adapter.RecyclerViewAdapter;
import com.josse.emile.mynews.R;

import java.io.IOException;
import java.util.ArrayList;



public class PageFragment extends Fragment {


    private TextView mTextView;
    private ArrayList<ArticlePojo> mArticleList = new ArrayList<>();
    private DAO mDAO = new DAO();

    private String mURL = "https://api.nytimes.com/svc/mostpopular/v2/emailed/1.json?api-key=31i5GXoUIzXUBZyZAIPB2mNkEGQ8UVd2";


    public PageFragment() { }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_page,container, false);
        mTextView = view.findViewById(R.id.fragment_page_title);

        int position = getArguments().getInt("pos");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        // TODO changer ce test pour chaque page dans le switch en dessous


        switch(position){
            case 1: mTextView.setText("blap");//recycler view here top stories

                //initArticlesArray(recyclerView,getContext(),"top", "blap");
                try {
                    mArticleList = mDAO.retrieveArticles(mURL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                initRecyclerView(recyclerView, getContext());
                break;
           case 2: mTextView.setText("blub");//recycler view here most popular
               initArticlesArray(recyclerView,getContext(),"https://i.redd.it/tpsnoz5bzo501.jpg","blub");
                break;
            default: mTextView.setText("gawap");//recycler view custom
                initArticlesArray(recyclerView,getContext(),"https://static01.nyt.com/images/2020/01/09/video/xxivid-iran-plane-2/xxivid-iran-plane-2-thumbStandard.jpg","gawap");
                break;
        }
        mTextView.setTextColor(Color.RED);

        return view;
    }

    private void initArticlesArray(RecyclerView view, Context context, String imageUrl, String articleTitle){

        int i = 0;
            while (i < 3) {
                mArticleList.add(new ArticlePojo(imageUrl, articleTitle, "4", "22/03/2020"));
                i++;
            }

        initRecyclerView(view, context);

    }

    private void initRecyclerView(RecyclerView view, Context context){
        RecyclerView recyclerView =  view;
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mArticleList , context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }



}
