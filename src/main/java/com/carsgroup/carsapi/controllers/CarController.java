package com.carsgroup.carsapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsgroup.carsapi.dto.CarDTO;
import com.carsgroup.carsapi.models.Car;
import com.carsgroup.carsapi.repository.CarRepository;


@RestController
@RequestMapping("/test/cars")
public class CarController {

  @Autowired
  private CarRepository repository;

  @PostMapping
  public void create(@RequestBody CarDTO req) {
    repository.save(new Car(req));
  }

  @GetMapping
  public List<Car> getAll(){
    return repository.findAll();
  }
}
