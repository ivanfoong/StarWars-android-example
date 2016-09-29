package com.example.starwars;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.starwarsapiclient.StarWarsApiClient;
import com.example.starwarsapiclient.callback.FilmsCallback;
import com.example.starwarsapiclient.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivanfoong on 29/9/16.
 */

public class FilmsFragment extends Fragment {

    private StarWarsApiClient mApiClient;
    private ListView mListView;
    private List<Film> mFilms;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApiClient = new StarWarsApiClient();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        mListView = (ListView) view.findViewById(R.id.list_view);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FilmDetailActivity.class);
                final Film selectedFilm = mFilms.get(position);
                intent.putExtra("film", selectedFilm);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        reloadFilms();
    }

    private void reloadFilms() {
        mApiClient.getFilms(new FilmsCallback() {
            @Override
            public void filmsCallback(List<Film> films) {
                mFilms = films;

                ArrayList<String> titles = new ArrayList<String>();
                for (Film film : films) {
                    titles.add(film.title);
                }

                final ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, titles);
                mListView.setAdapter(nameAdapter);
            }

            @Override
            public void errorCallback(Throwable throwable) {

            }
        });
    }
}
