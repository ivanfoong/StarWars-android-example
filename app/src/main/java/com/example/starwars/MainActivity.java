package com.example.starwars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.starwarsapiclient.StarWarsApiClient;
import com.example.starwarsapiclient.callback.PeopleCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private StarWarsApiClient mApiClient;
    private ListView mListView;
    private List<Person> mPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();

        reloadPeople();
    }

    private void init() {
        mApiClient = new StarWarsApiClient();
        mListView = (ListView) findViewById(R.id.list_view);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                final Person selectedPerson = mPeople.get(position);
                intent.putExtra("person", selectedPerson);
                startActivity(intent);
            }
        });
    }

    private void reloadPeople() {
        mApiClient.getPeople(new PeopleCallback() {
            @Override
            public void peopleCallback(List<com.example.starwarsapiclient.model.Person> people) {
                ArrayList<Person> newPeople = new ArrayList<>();
                ArrayList<String> names = new ArrayList<String>();
                for (com.example.starwarsapiclient.model.Person person : people) {
                    final Person newPerson = new Person(person);
                    newPeople.add(newPerson);
                    names.add(newPerson.name);
                }
                mPeople = newPeople;
                final ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_view, names);
                mListView.setAdapter(nameAdapter);
            }

            @Override
            public void errorCallback(Throwable throwable) {
                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_LONG);
            }
        });
    }
}
