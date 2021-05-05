package com.example.springdemo;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<CityEntity, Long> {
    List<CityEntity> findByName(String name);
    List<CityEntity> findByShortname(String shortname);
}
