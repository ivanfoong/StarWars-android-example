package com.example.starwars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.starwarsapiclient.model.Film;

import java.net.URL;

/**
 * Created by ivanfoong on 27/9/16.
 */

public class FilmDetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private EditText mTitleEditText;
    private EditText mEpisodeIdEditText;
    private EditText mCharacterUrlsEditText;
    private EditText mDirectorEditText;
    private EditText mOpeningCrawlEditText;
    private EditText mPlanetUrlsEditText;
    private EditText mReleaseDateEditText;
    private EditText mSpecieUrlsEditText;
    private EditText mVehicleUrlsEditText;
    private EditText mStarshipUrlsEditText;
    private EditText mCreatedEditText;
    private EditText mEditedEditText;
    private EditText mUrlEditText;
    private Film mFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();

        updateUI();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitleEditText = (EditText) findViewById(R.id.input_title);
        mEpisodeIdEditText = (EditText) findViewById(R.id.input_episode_id);
        mCharacterUrlsEditText = (EditText) findViewById(R.id.input_character_urls);
        mDirectorEditText = (EditText) findViewById(R.id.input_director);
        mOpeningCrawlEditText = (EditText) findViewById(R.id.input_opening_crawl);
        mPlanetUrlsEditText = (EditText) findViewById(R.id.input_planet_urls);
        mReleaseDateEditText = (EditText) findViewById(R.id.input_release_date);
        mSpecieUrlsEditText = (EditText) findViewById(R.id.input_specie_urls);
        mVehicleUrlsEditText = (EditText) findViewById(R.id.input_vehicle_urls);
        mStarshipUrlsEditText = (EditText) findViewById(R.id.input_starship_urls);
        mCreatedEditText = (EditText) findViewById(R.id.input_created);
        mEditedEditText = (EditText) findViewById(R.id.input_edited);
        mUrlEditText = (EditText) findViewById(R.id.input_url);

        mFilm = getIntent().getParcelableExtra("film");
    }

    private void updateUI() {
        if (mFilm != null) {
            getSupportActionBar().setTitle(mFilm.title);

            if (mTitleEditText != null) {
                mTitleEditText.setText(mFilm.title);
            }

            if (mEpisodeIdEditText != null) {
                mEpisodeIdEditText.setText(String.valueOf(mFilm.episodeId));
            }

            if (mCharacterUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mFilm.characterUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mCharacterUrlsEditText.setText(sb.toString());
            }

            if (mDirectorEditText != null) {
                mDirectorEditText.setText(mFilm.director);
            }

            if (mOpeningCrawlEditText != null) {
                mOpeningCrawlEditText.setText(mFilm.openingCrawl);
            }

            if (mPlanetUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mFilm.planetUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mPlanetUrlsEditText.setText(sb.toString());
            }

            if (mReleaseDateEditText != null) {
                mReleaseDateEditText.setText(mFilm.releaseDate.toLocaleString());
            }

            if (mSpecieUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mFilm.specieUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mSpecieUrlsEditText.setText(sb.toString());
            }

            if (mVehicleUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mFilm.vehicleUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mVehicleUrlsEditText.setText(sb.toString());
            }

            if (mStarshipUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mFilm.starshipUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mStarshipUrlsEditText.setText(sb.toString());
            }

            if (mCreatedEditText != null) {
                mCreatedEditText.setText(mFilm.created.toLocaleString());
            }

            if (mEditedEditText != null) {
                mEditedEditText.setText(mFilm.edited.toLocaleString());
            }

            if (mUrlEditText != null) {
                mUrlEditText.setText(mFilm.url.toString());
            }
        }
    }
}
