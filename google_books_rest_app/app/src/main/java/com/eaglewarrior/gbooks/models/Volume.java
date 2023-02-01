package com.eaglewarrior.gbooks.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Clarence E Moore on 2023-01-21.
 * <p>
 * Description:
 */

public class Volume {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("etag")
    @Expose
    private String etag;

    @SerializedName("selfLink")
    @Expose
    private String selfLink;

    @SerializedName("volumeInfo")
    @Expose
    VolumeInfo volumeInfo;

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public String getKind() {

        return kind;
    }
    public String getId() {

        return id;
    }

}
