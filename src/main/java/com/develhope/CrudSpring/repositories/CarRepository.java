package com.develhope.CrudSpring.repositories;

import com.develhope.CrudSpring.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}


