package com.sinch.polishnotationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsVO {

    List<ResultVO> results;

    public List<ResultVO> getResults() {
        return results;
    }

    public void setResults(List<ResultVO> results) {
        this.results = results;
    }
}
