package com.example.springdemo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMap {
    private List<City> list;
    private int cod;
    private double calctime;
    private int cnt;

    public List<City> getList() {
        //list.sort(Comparator.comparing(City::toString));
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getCalctime() {
        return calctime;
    }

    public void setCalctime(double calctime) {
        this.calctime = calctime;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public OpenWeatherMap(List<City> list, int cod, double calctime, int cnt) {


        this.list = list;
        this.cod = cod;
        this.calctime = calctime;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "OpenWeatherMap{" +
                "list=" + list +
                ", cod=" + cod +
                ", calctime=" + calctime +
                ", cnt=" + cnt +
                '}';
    }
}
