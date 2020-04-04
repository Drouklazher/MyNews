package com.josse.emile.mynews.Model;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.*;
import com.josse.emile.mynews.Model.POJOS.ArticlePojo;
import com.josse.emile.mynews.Model.POJOS.Results.ResultPOJO;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DAO  {

    private OkHttpClient mOkHttpClient;
    private String mArticleString;

    public DAO(){
        mOkHttpClient = new OkHttpClient();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void getArticlesString(String url)  {
        mArticleString = null;
        final Request myGetRequest = new Request.Builder()
                .url(url)
                .build();


        mOkHttpClient.newCall(myGetRequest).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 if (response.isSuccessful()){
                     assert response.body() != null;
                     DAO.this.mArticleString = response.body().string();


                 }else {
                     mArticleString = "bawap";
                 }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ArrayList<ArticlePojo> retrieveArticles(String type) throws InterruptedException {
        ResultPOJO resultPOJO ;

         getArticlesString(type);
         int i = 0;
         while(mArticleString == null && i < 50){
            Thread.sleep(100);
            i++;
         }
         if (mArticleString == null){
             ArrayList<ArticlePojo> tmpList = new ArrayList<>();
             tmpList.add(new ArticlePojo("https://www.yourfirst10kreaders.com/wp-content/uploads/2015/03/New-York-Times-Logo.png", "no data", "",""));
             return tmpList;
         }else {

             Gson g = new Gson();

             resultPOJO = g.fromJson(mArticleString, ResultPOJO.class);

             return resultPOJO.toArticlePOJOList();
         }
    }
}
