package com.aleksandr.blogca2023.service;

import com.aleksandr.blogca2023.entities.Car;
import com.aleksandr.blogca2023.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> searchByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
}