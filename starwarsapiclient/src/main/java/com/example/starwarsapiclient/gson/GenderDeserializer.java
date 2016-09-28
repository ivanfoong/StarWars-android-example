package com.example.starwarsapiclient.gson;

import com.example.starwarsapiclient.model.Gender;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by pifk033z on 27/9/16.
 */

public class GenderDeserializer implements JsonDeserializer<Gender> {
    @Override
    public Gender deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final String genderString = json.getAsJsonPrimitive().getAsString();
        return Gender.fromString(genderString);
    }
}
