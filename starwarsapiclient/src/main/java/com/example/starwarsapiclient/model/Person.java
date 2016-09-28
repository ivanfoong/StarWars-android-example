package com.example.starwarsapiclient.model;

import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by pifk033z on 27/9/16.
 */

public class Person {
    public String name;

    public int height;

    public int mass;

    @SerializedName("hair_color")
    public String hairColor;

    @SerializedName("skin_color")
    public String skinColor;

    @SerializedName("eye_color")
    public String eyeColor;

    @SerializedName("birth_year")
    public String birthYear;

    public Gender gender;

    @SerializedName("homeworld")
    public URL homeworldUrl;

    @SerializedName("films")
    public List<URL> filmUrls;

    @SerializedName("species")
    public List<URL> specieUrls;

    @SerializedName("vehicles")
    public List<URL> vehicleUrls;

    @SerializedName("starships")
    public List<URL> starshipUrls;

    public Date created;
    public Date edited;
    public URL url;
}
