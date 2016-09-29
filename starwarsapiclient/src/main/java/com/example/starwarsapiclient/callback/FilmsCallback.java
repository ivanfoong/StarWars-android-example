package com.example.starwarsapiclient.callback;

import com.example.starwarsapiclient.model.Film;

import java.util.List;

public interface FilmsCallback extends Callback {
    void filmsCallback(List<Film> films);
}
