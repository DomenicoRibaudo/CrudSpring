package com.develhope.CrudSpring.controller;

import com.develhope.CrudSpring.entities.Car;
import com.develhope.CrudSpring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CarController {
    @Autowired
    private CarService carService;

    //crea nuova Car
    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok().body(carService.addCar(car));
    }

    //cancella la Car specifica
    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable Long id){
        Optional<Car> carOptional = carService.deleteCarById(id);
        if(carOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carOptional.get());
    }

    //cancella tutte le Cars in db
    @DeleteMapping("deleteAllCars")
    public void deleteAllCars(){
        carService.deleteAllCars();
    }

    //restituisce una singola Car
    @GetMapping("/getSingleCar/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Optional<Car> carOptional = carService.getSingleCar(id);
        if (carOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carOptional.get());
    }

    //aggiorna type della Car specifica
    @PutMapping("/updatecar/{id}")
    public ResponseEntity<Car> updateCarType(@PathVariable Long id, @RequestParam String Type){
        Optional<Car> carOptional = carService.updateCarType(id, Type);
        if(carOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carOptional.get());
    }

    //restituisce la lista di tutte le Car
    @GetMapping("/visualizzaTutto")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }
}