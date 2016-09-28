package com.example.starwars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.net.URL;

/**
 * Created by pifk033z on 27/9/16.
 */

public class DetailActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mHeightEditText;
    private EditText mMassEditText;
    private EditText mHairColorEditText;
    private EditText mSkinColorEditText;
    private EditText mEyeColorEditText;
    private EditText mBirthYearEditText;
    private EditText mGenderEditText;
    private EditText mHomeworldUrlEditText;
    private EditText mFilmUrlsEditText;
    private EditText mSpecieUrlsEditText;
    private EditText mVehicleUrlsEditText;
    private EditText mStarshipUrlsEditText;
    private EditText mCreatedEditText;
    private EditText mEditedEditText;
    private EditText mUrlEditText;
    private Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();

        updateUI();
    }

    private void init() {
        mNameEditText = (EditText) findViewById(R.id.input_name);
        mHeightEditText = (EditText) findViewById(R.id.input_height);
        mMassEditText = (EditText) findViewById(R.id.input_mass);
        mHairColorEditText = (EditText) findViewById(R.id.input_hair_color);
        mSkinColorEditText = (EditText) findViewById(R.id.input_skin_color);
        mEyeColorEditText = (EditText) findViewById(R.id.input_eye_color);
        mBirthYearEditText = (EditText) findViewById(R.id.input_birth_year);
        mGenderEditText = (EditText) findViewById(R.id.input_gender);
        mHomeworldUrlEditText = (EditText) findViewById(R.id.input_homeworld_url);
        mFilmUrlsEditText = (EditText) findViewById(R.id.input_film_urls);
        mSpecieUrlsEditText = (EditText) findViewById(R.id.input_specie_urls);
        mVehicleUrlsEditText = (EditText) findViewById(R.id.input_vehicle_urls);
        mStarshipUrlsEditText = (EditText) findViewById(R.id.input_starship_urls);
        mCreatedEditText = (EditText) findViewById(R.id.input_created);
        mEditedEditText = (EditText) findViewById(R.id.input_edited);
        mUrlEditText = (EditText) findViewById(R.id.input_url);

        mPerson = getIntent().getParcelableExtra("person");
    }

    private void updateUI() {
        if (mPerson != null) {
            if (mNameEditText != null) {
                mNameEditText.setText(mPerson.name);
            }

            if (mHeightEditText != null) {
                mHeightEditText.setText(String.valueOf(mPerson.height));
            }

            if (mMassEditText != null) {
                mMassEditText.setText(String.valueOf(mPerson.mass));
            }

            if (mHairColorEditText != null) {
                mHairColorEditText.setText(mPerson.hairColor);
            }

            if (mSkinColorEditText != null) {
                mSkinColorEditText.setText(mPerson.skinColor);
            }

            if (mEyeColorEditText != null) {
                mEyeColorEditText.setText(mPerson.eyeColor);
            }

            if (mBirthYearEditText != null) {
                mBirthYearEditText.setText(mPerson.birthYear);
            }

            if (mGenderEditText != null) {
                mGenderEditText.setText(mPerson.gender.getGenderString());
            }

            if (mHomeworldUrlEditText != null) {
                mHomeworldUrlEditText.setText(mPerson.homeworldUrl.toString());
            }

            if (mFilmUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mPerson.filmUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mFilmUrlsEditText.setText(sb.toString());
            }

            if (mSpecieUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mPerson.specieUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mSpecieUrlsEditText.setText(sb.toString());
            }

            if (mVehicleUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mPerson.vehicleUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mVehicleUrlsEditText.setText(sb.toString());
            }

            if (mStarshipUrlsEditText != null) {
                final StringBuilder sb = new StringBuilder();
                for (URL url : mPerson.starshipUrls) {
                    if (sb.length() > 0) { sb.append(", "); }
                    sb.append(url.toString());
                }
                mStarshipUrlsEditText.setText(sb.toString());
            }

            if (mCreatedEditText != null) {
                mCreatedEditText.setText(mPerson.created.toLocaleString());
            }

            if (mEditedEditText != null) {
                mEditedEditText.setText(mPerson.edited.toLocaleString());
            }

            if (mUrlEditText != null) {
                mUrlEditText.setText(mPerson.url.toString());
            }
        }
    }
}
