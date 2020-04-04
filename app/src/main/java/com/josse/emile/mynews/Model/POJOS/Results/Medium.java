package com.josse.emile.mynews.Model.POJOS.Results;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medium {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("subtype")
    @Expose
    public String subtype;
    @SerializedName("caption")
    @Expose
    public String caption;
    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    public Integer approvedForSyndication;
    @SerializedName("media-metadata")
    @Expose
    public List<MediaMetadatum> mediaMetadata = null;
}
