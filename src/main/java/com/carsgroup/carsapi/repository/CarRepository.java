package com.carsgroup.carsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carsgroup.carsapi.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
  
}
