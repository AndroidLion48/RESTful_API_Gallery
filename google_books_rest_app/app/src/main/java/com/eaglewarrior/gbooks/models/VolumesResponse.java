package com.eaglewarrior.gbooks.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Clarence E Moore on 2023-01-21.
 * <p>
 * Description:
 */

// Adapter???
public class VolumesResponse {
    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("items")
    @Expose
    List<Volume> items = null;

    @SerializedName("totalItems")
    @Expose
    int totalItems;

    public String getKind() {

        return kind;
    }

    public List<Volume> getItems() {

        return items;
    }

    public int getTotalItems() {

        return totalItems;
    }
}
