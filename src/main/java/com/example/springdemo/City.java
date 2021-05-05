package com.example.springdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    private String name;
    private Main main;
    private Wind wind;
    private List<Weather> weather;
    private String shortname;

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public City(String name, Main main, Wind wind, List<Weather> weather) {
        this.name = name;
        this.main = main;
        this.wind = wind;
        this.weather = weather;
        shortname = null;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", main=" + main +
                ", wind=" + wind +
                ", weather=" + weather +
                ", shortname='" + shortname + '\'' +
                '}';
    }
}
