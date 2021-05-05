package com.example.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTask {

    //protected static OpenWeatherMap owm;
    private final Producer producer;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    public ScheduledTask(Producer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {


        OpenWeatherMap owm = restTemplate.getForObject(
                "http://api.openweathermap.org/"+
                        "data/2.5/box/city?bbox=-9.7,36.7,-5.9,42.3,9&appid=050a536236459af2a80a2d"+
                        "7843f5adda&units=metric", OpenWeatherMap.class);

        log.info(owm.toString());
        this.producer.sendMessage("Temperatura de Aveiro abaixo de 20º. ");
        this.producer.sendMessage("Temperatura de Leiria abaixo de 23º. ");


    }
}