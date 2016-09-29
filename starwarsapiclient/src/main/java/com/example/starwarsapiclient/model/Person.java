package com.example.starwarsapiclient.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pifk033z on 27/9/16.
 */

public class Person implements Parcelable {
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

    protected Person(Parcel in) {
        name = in.readString();
        height = in.readInt();
        mass = in.readInt();
        hairColor = in.readString();
        skinColor = in.readString();
        eyeColor = in.readString();
        birthYear = in.readString();
        gender = Gender.fromString(in.readString());
        homeworldUrl = (URL) in.readSerializable();

        filmUrls = new ArrayList<>();
        in.readList(filmUrls, null);

        specieUrls = new ArrayList<>();
        in.readList(specieUrls, null);

        vehicleUrls = new ArrayList<>();
        in.readList(vehicleUrls, null);

        starshipUrls = new ArrayList<>();
        in.readList(starshipUrls, null);

        created = (Date) in.readSerializable();
        edited = (Date) in.readSerializable();
        url = (URL) in.readSerializable();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(height);
        dest.writeInt(mass);
        dest.writeString(hairColor);
        dest.writeString(skinColor);
        dest.writeString(eyeColor);
        dest.writeString(birthYear);
        dest.writeString(gender.getGenderString());
        dest.writeSerializable(homeworldUrl);
        dest.writeList(filmUrls);
        dest.writeList(specieUrls);
        dest.writeList(vehicleUrls);
        dest.writeList(starshipUrls);
        dest.writeSerializable(created);
        dest.writeSerializable(edited);
        dest.writeSerializable(url);
    }
}
