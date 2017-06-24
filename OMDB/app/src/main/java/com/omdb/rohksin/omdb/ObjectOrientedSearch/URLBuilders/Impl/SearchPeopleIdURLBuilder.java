package com.omdb.rohksin.omdb.ObjectOrientedSearch.URLBuilders.Impl;

/**
 * Created by Illuminati on 6/24/2017.
 */
public class SearchPeopleIdURLBuilder extends SearchIDURLBuilder {

    private String people_id;

    public SearchPeopleIdURLBuilder(String people_id)
    {
        this.people_id = people_id;
    }

    @Override
    public String getSpecific() {
        return "person/";
    }

    @Override
    public String getSeachTerm() {
        return people_id+"?";
    }

    @Override
    public String getQueryParams() {
        return "&language=en-US&append_to_response=movie_credits,images,tagged_images";
    }
}
