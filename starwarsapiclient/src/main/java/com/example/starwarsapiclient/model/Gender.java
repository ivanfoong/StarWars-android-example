package com.example.starwarsapiclient.model;

/**
 * Created by pifk033z on 27/9/16.
 */

public enum Gender {
    Unknown(""), Male("male"), Female("female");

    String genderString;

    Gender(String genderString) {
        this.genderString = genderString;
    }

    public String getGenderString() {
        return genderString;
    }

    public static Gender fromString(String genderString) {
        for (Gender gender : Gender.values()) {
            if (gender.genderString.equalsIgnoreCase(genderString)) {
                return gender;
            }
        }
        return Gender.Unknown;
    }
}
