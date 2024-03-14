package com.develhope.CrudSpring.service;

import com.develhope.CrudSpring.entities.Car;
import com.develhope.CrudSpring.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    public CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getSingleCar(Long id) {
        return carRepository.findById(id);
    }


    //aggiorna type della Car specifica, identificata da id e passando query param
    // - se id non è presente in db, restituisce Car vuota
    public Optional<Car> updateCarType(Long id, String type) {
        Optional<Car> carOptional = carRepository.findById(id);
        //se l'oggetto è presente
        if (carOptional.isPresent()) {

            //modifichiamo il type
            carOptional.get().setType(type);

            //salviamo l'oggetto aggiornato
            Car carUpdated = carRepository.saveAndFlush(carOptional.get());

            //ritorniamo l'oggetto che è stato aggiornato
            return Optional.of(carUpdated);

        } else {
            //se non presente ritorniamo un oggetto vuoto
            return Optional.empty();
        }

    }

    public Optional<Car> deleteCarById(Long id) {
        //recuperiamo l'oggetto da eliminare tramite l'id
        Optional<Car> carOptional = carRepository.findById(id);
        //controlliamo che l'oggetto sia presente
        if(carOptional.isPresent()){
            //cancelliamo l'oggetto
            carRepository.delete(carOptional.get());
        } else {
            //se non presente viene ritornato un oggetto vuoto
            return Optional.empty();
        }
        //ritorniamo l'oggetto cancellato
        return carOptional;
    }


    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}

