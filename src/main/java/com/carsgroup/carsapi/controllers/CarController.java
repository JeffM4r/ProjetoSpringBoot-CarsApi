package com.carsgroup.carsapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsgroup.carsapi.dto.CarDTO;


@RestController
@RequestMapping("/test")
public class CarController {
  @PostMapping("/cars")
  public void create(@RequestBody CarDTO req) {
    System.out.println(req);
  }
}
