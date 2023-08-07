package com.carsgroup.carsapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsgroup.carsapi.dto.CarDTO;
import com.carsgroup.carsapi.models.Car;
import com.carsgroup.carsapi.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/test/cars")
public class CarController {

  @Autowired
  private CarRepository repository;

  @PostMapping
  public void create(@RequestBody @Valid CarDTO req) {
    repository.save(new Car(req));
  }

  @GetMapping
  public List<Car> getAll() {
    return repository.findAll();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
    repository.findById(id).map(oldCar -> {
      oldCar.setAnoModelo(req.anoModelo());
      oldCar.setDataFabricacao(req.dataFabricacao());
      oldCar.setModelo(req.modelo());
      oldCar.setValor(req.valor());
      oldCar.setFabricante(req.fabricante());
      
      return repository.save(oldCar);
    });
  }
}
