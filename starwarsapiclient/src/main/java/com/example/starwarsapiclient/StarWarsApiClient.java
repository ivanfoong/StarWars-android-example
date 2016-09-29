package com.example.starwarsapiclient;

import com.example.starwarsapiclient.Response.FilmsResponse;
import com.example.starwarsapiclient.callback.FilmsCallback;
import com.example.starwarsapiclient.callback.PeopleCallback;
import com.example.starwarsapiclient.gson.GenderDeserializer;
import com.example.starwarsapiclient.gson.UrlDeserializer;
import com.example.starwarsapiclient.model.Film;
import com.example.starwarsapiclient.model.Gender;
import com.example.starwarsapiclient.Response.PeopleResponse;
import com.example.starwarsapiclient.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pifk033z on 27/9/16.
 */

public class StarWarsApiClient {
    private final Retrofit mRetrofit;
    private final StarWarsApiService mService;

    public StarWarsApiClient() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
                .registerTypeAdapter(URL.class, new UrlDeserializer())
                .registerTypeAdapter(Gender.class, new GenderDeserializer())
                .create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mService = mRetrofit.create(StarWarsApiService.class);
    }

    public List<Person> getPeople() {
        try {
            final PeopleResponse response = mService.getPeople().execute().body();
            return response.results;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Person>();
    }

    public void getPeople(final PeopleCallback callback) {
        mService.getPeople().enqueue(new Callback<PeopleResponse>() {

            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                final PeopleResponse peopleResponse = response.body();
                callback.peopleCallback(peopleResponse.results);
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                callback.errorCallback(t);
            }
        });
    }

    public List<Film> getFilms() {
        try {
            final FilmsResponse response = mService.getFilms().execute().body();
            return response.results;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Film>();
    }

    public void getFilms(final FilmsCallback callback) {
        mService.getFilms().enqueue(new Callback<FilmsResponse>() {
            @Override
            public void onResponse(Call<FilmsResponse> call, Response<FilmsResponse> response) {
                final FilmsResponse filmsResponse = response.body();
                callback.filmsCallback(filmsResponse.results);
            }

            @Override
            public void onFailure(Call<FilmsResponse> call, Throwable t) {
                callback.errorCallback(t);
            }
        });
    }
}

