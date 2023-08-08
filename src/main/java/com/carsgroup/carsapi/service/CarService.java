package com.carsgroup.carsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsgroup.carsapi.dto.CarDTO;
import com.carsgroup.carsapi.models.Car;
import com.carsgroup.carsapi.repository.CarRepository;

@Service
public class CarService {

  @Autowired
  private CarRepository repository;

  public void create(Car item){
    repository.save(item);
  }

  public List<Car> getAll(){
    return repository.findAll();
  }

  public void deleteByID(Long id){
    repository.deleteById(id);
  }

  public void update(Long id, CarDTO item){
    repository.findById(id).map(oldCar -> {
      oldCar.setAnoModelo(item.anoModelo());
      oldCar.setDataFabricacao(item.dataFabricacao());
      oldCar.setModelo(item.modelo());
      oldCar.setValor(item.valor());
      oldCar.setFabricante(item.fabricante());
      
      return repository.save(oldCar);
    });
  }
}
