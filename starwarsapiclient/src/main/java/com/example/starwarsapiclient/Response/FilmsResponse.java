package com.example.starwarsapiclient.Response;

import com.example.starwarsapiclient.model.Film;
import com.example.starwarsapiclient.model.Person;

import java.util.List;

/**
 * Created by pifk033z on 27/9/16.
 */

public class FilmsResponse extends BaseResponse {
    public List<Film> results;
}
