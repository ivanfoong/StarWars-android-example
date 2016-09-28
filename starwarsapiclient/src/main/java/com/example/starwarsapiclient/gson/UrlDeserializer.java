package com.example.starwarsapiclient.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pifk033z on 27/9/16.
 */

public class UrlDeserializer implements JsonDeserializer<URL> {
    @Override
    public URL deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final String urlString = json.getAsJsonPrimitive().getAsString();
        final URL url;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new JsonParseException(e.getMessage());
        }
        return url;
    }
}
