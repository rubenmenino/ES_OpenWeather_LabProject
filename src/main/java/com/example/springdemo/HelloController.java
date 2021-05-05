package com.example.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.*;

@RestController
public class HelloController {

    final Logger log = LoggerFactory.getLogger(HelloController.class);
    int cnt = 0;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CityRepository repository;

    @RequestMapping("/")
    public ModelAndView index() {
        log.debug("[" + cnt++ + "]" + " Index");

        OpenWeatherMap owm = restTemplate.getForObject(
                "http://api.openweathermap.org/"+
                        "data/2.5/box/city?bbox=-9.7,36.7,-5.9,42.3,9&appid=050a536236459af2a80a2d"+
                        "7843f5adda&units=metric", OpenWeatherMap.class);


        log.info(owm.toString());

        for (City city: owm.getList()) {
            String newshortname = Normalizer.normalize(city.getName().replaceAll("\\s+","").toLowerCase(), Normalizer.Form.NFD)
                    .replaceAll("[^\\p{ASCII}]", "");

            log.info("newshortname " + newshortname);

            city.setShortname(newshortname);

            Date date = new Date();
            String pattern = "yyyy:MM:dd:HH:mm:ss";
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            CityEntity omega = new CityEntity(
                    city.getName(),
                    city.getShortname(),
                    city.getMain().getTemp(),
                    dateFormat.format(date),
                    city.getWind().getSpeed());
            log.info("Iter."+omega.toString());
            repository.save(omega);
        }

        String viewName = "index";
        Map<String, Object> model = new HashMap<>();
        model.put("cities", owm.getList());
        model.put("adicionar", repository.findAll() );

        return new ModelAndView(viewName, model);
    }

    @RequestMapping(value = "/city/{cityname}", method = RequestMethod.GET)
    public ModelAndView individualCity(@PathVariable String cityname) {

        String viewName = "individual";
        Map<String, Object> model = new HashMap<>();

        if (repository.findByShortname(cityname).size() == 0) {
            model.put("error", "Invalid City");
            return new ModelAndView(viewName, model);
        }

        else {
            List<CityEntity> lista = repository.findByShortname(cityname);
            List<?> reverselista = lista.subList(0, lista.size());
            Collections.reverse(reverselista);

            log.info("reverselista " + reverselista.toString());

            Map<String, Double> dadosTemp = new LinkedHashMap<>();
            for (Object tmpcity: reverselista) {
                CityEntity city = (CityEntity) tmpcity;
                dadosTemp.put(city.getDate(), city.getTemp());
            }
            log.info("dadosTemp " + dadosTemp.toString());

            model.put("cityentities", reverselista);
            model.put("dadosTemp", dadosTemp);
            return new ModelAndView(viewName, model);
        }

    }

    @GetMapping(value = "/sort")
    public ModelAndView getCitySort(){
        OpenWeatherMap owm = restTemplate.getForObject(
                "http://api.openweathermap.org/"+
                        "data/2.5/box/city?bbox=-9.7,36.7,-5.9,42.3,9&appid=050a536236459af2a80a2d"+
                        "7843f5adda&units=metric", OpenWeatherMap.class);

        String viewName = "index";

        Map<String, Object> model = new HashMap<>();

        List<City> orderCities = owm.getList();
        System.out.print("Ordered\n" + orderCities);
        orderCities.sort(Comparator.comparing(City::toString));

        model.put("cities", orderCities);

        return new ModelAndView(viewName, model);

    }




}