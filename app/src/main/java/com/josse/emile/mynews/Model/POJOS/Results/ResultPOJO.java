package com.josse.emile.mynews.Model.POJOS.Results;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.josse.emile.mynews.Model.POJOS.ArticlePojo;

public class ResultPOJO {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("num_results")
    @Expose
    public Integer numResults;
    @SerializedName("results")
    @Expose
    public List<Result> results = null;

    public ArrayList<ArticlePojo> toArticlePOJOList(){
        ArrayList<ArticlePojo> articlePojoList = new ArrayList<>();

        for (int i = 0; i < this.numResults - 1; i++){
            Result tmpResult = this.results.get(i);
            Log.e("pojoTrans", tmpResult.title);
            if (tmpResult.media.size() > 0) {
                articlePojoList.add(new ArticlePojo(tmpResult.media.get(0).mediaMetadata.get(0).url, tmpResult.title, tmpResult.url, tmpResult.publishedDate));
            }else {
                articlePojoList.add(new ArticlePojo("https://www.yourfirst10kreaders.com/wp-content/uploads/2015/03/New-York-Times-Logo.png", tmpResult.title, tmpResult.url, tmpResult.publishedDate));
            }
        }
        return articlePojoList;
    }

}