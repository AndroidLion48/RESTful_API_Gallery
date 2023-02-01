package com.eaglewarrior.gbooks.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clarence E Moore on 2023-01-21.
 * <p>
 * Description:
 */

public class VolumeImageLinks {

    @SerializedName("smallThumbnail")
    @Expose
    private String smallThumbnail;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
