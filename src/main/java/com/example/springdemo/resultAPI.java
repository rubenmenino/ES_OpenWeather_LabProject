package com.example.springdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class resultAPI {
    private List<Weather> weathers;

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public resultAPI(){};

    @Override
    public String toString() {
        return "resultAPI{" +
                "weathers=" + weathers +
                '}';
    }
}
