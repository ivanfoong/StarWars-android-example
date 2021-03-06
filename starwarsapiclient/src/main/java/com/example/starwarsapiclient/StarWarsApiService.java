package com.example.starwarsapiclient;

import com.example.starwarsapiclient.Response.FilmsResponse;
import com.example.starwarsapiclient.Response.PeopleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pifk033z on 27/9/16.
 */

public interface StarWarsApiService {
    @GET("people/")
    Call<PeopleResponse> getPeople();

    @GET("films/")
    Call<FilmsResponse> getFilms();
}
