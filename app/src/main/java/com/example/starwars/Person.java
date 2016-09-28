package com.example.starwars;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.starwarsapiclient.model.Gender;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pifk033z on 28/9/16.
 */

public class Person extends com.example.starwarsapiclient.model.Person implements Parcelable {

    public Person(com.example.starwarsapiclient.model.Person person) {
        super();

        name = person.name;
        height = person.height;
        mass = person.mass;
        hairColor = person.hairColor;
        skinColor = person.skinColor;
        eyeColor = person.eyeColor;
        birthYear = person.birthYear;
        gender = person.gender;
        homeworldUrl = person.homeworldUrl;
        filmUrls = person.filmUrls;
        specieUrls = person.specieUrls;
        vehicleUrls = person.vehicleUrls;
        starshipUrls = person.starshipUrls;
        created = person.created;
        edited = person.edited;
        url = person.url;
    }

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
