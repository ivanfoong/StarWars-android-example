package com.example.starwarsapiclient.callback;

import com.example.starwarsapiclient.model.Person;

import java.util.List;

public interface PeopleCallback extends Callback {
    void peopleCallback(List<Person> people);
}
