package com.example.springdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    private double temp;
    private double feels_like;
    private double temp_max;
    private double temp_min;
    private double humidity;

    public double getTemp_max() {

        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Main(Double temp, Double feels_like) {
        this.temp=temp;
        this.feels_like=feels_like;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", temp_max=" + temp_max +
                ", temp_min=" + temp_min +
                ", humidity=" + humidity +
                '}';
    }


}