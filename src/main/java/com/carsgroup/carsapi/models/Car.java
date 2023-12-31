package com.carsgroup.carsapi.models;

import com.carsgroup.carsapi.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {

  public Car(CarDTO req){
    this.modelo = req.modelo();
    this.fabricante = req.fabricante(); 
    this.dataFabricacao = req.dataFabricacao();
    this.valor  = req.valor();
    this.anoModelo = req.anoModelo();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String modelo;

  @Column(length = 50, nullable = false)
  private String fabricante;

  @Column(length = 10, nullable = false)
  private String dataFabricacao;

  @Column(length = 50, nullable = false)
  private double valor;

  @Column(length = 50, nullable = false)
  private int anoModelo;  
}
