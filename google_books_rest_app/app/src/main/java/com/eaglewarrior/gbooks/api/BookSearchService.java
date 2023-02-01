package com.eaglewarrior.gbooks.api;

import com.eaglewarrior.gbooks.models.VolumesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Clarence E Moore on 2023-01-21.
 * <p>
 * Description:
 */

public interface BookSearchService {

    @GET("/books/v1/volumes")
    Call<VolumesResponse> searchVolumes(
            @Query("q") String query,
            @Query("inauthor") String author,
            @Query("key") String apiKey);
}
