package com.example.starwarsapiclient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ivanfoong on 29/9/16.
 */

public class Film implements Parcelable {
    @SerializedName("characters")
    public List<URL> characterUrls;

    public Date created;
    public String director;
    public Date edited;

    @SerializedName("episode_id")
    public int episodeId;

    @SerializedName("opening_crawl")
    public String openingCrawl;

    @SerializedName("planets")
    public List<URL> planetUrls;

    public String producer;

    @SerializedName("release_date")
    public Date releaseDate;

    @SerializedName("species")
    public List<URL> specieUrls;

    @SerializedName("starships")
    public List<URL> starshipUrls;

    public String title;
    public URL url;

    @SerializedName("vehicles")
    public List<URL> vehicleUrls;

    protected Film(Parcel in) {
        characterUrls = new ArrayList<>();
        in.readList(characterUrls, null);

        created = (Date) in.readSerializable();
        director = in.readString();
        edited = (Date) in.readSerializable();
        episodeId = in.readInt();
        openingCrawl = in.readString();

        planetUrls = new ArrayList<>();
        in.readList(planetUrls, null);

        producer = in.readString();
        releaseDate = (Date) in.readSerializable();

        specieUrls = new ArrayList<>();
        in.readList(specieUrls, null);

        starshipUrls = new ArrayList<>();
        in.readList(starshipUrls, null);

        title = in.readString();
        url = (URL) in.readSerializable();

        vehicleUrls = new ArrayList<>();
        in.readList(vehicleUrls, null);
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(characterUrls);
        dest.writeSerializable(created);
        dest.writeString(director);
        dest.writeSerializable(edited);
        dest.writeInt(episodeId);
        dest.writeString(openingCrawl);
        dest.writeList(planetUrls);
        dest.writeString(producer);
        dest.writeSerializable(releaseDate);
        dest.writeList(specieUrls);
        dest.writeList(starshipUrls);
        dest.writeString(title);
        dest.writeSerializable(url);
        dest.writeList(vehicleUrls);
    }
}