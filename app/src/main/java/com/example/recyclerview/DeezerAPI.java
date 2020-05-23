package com.example.recyclerview;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DeezerAPI {
    @GET("/user/18732266/playlists")
    Call<RestDeezerResponse> getDeezerResponse();
}
