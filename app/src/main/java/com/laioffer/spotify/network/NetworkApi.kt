package com.laioffer.spotify.network

import com.laioffer.spotify.datamodel.Section
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    //http://0.0.0.0:8080/feed
    @GET("feed")
    fun getHomeFeed(): Call<List<Section>>
}

/*
public interface GitHubService {
  @GET("users/{user}/repos")
  Call<List<Repo>> listRepos(@Path("user") String user);
}
 */