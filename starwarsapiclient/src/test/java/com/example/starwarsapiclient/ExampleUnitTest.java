package com.example.starwarsapiclient;

import com.example.starwarsapiclient.model.Person;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void getPeople_returnsPeople() throws Exception {
        final StarWarsApiClient apiClient = new StarWarsApiClient();
        final List<Person> people = apiClient.getPeople();
        assertTrue("has atleast 1 person", people.size() > 0);
    }
}