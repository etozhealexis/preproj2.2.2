package ru.etozhealexis.springboot.service;

import ru.etozhealexis.springboot.model.Car;

import java.util.List;

public interface CarService {
    List<Car> listCars(Integer count);

    List<Car> listCars(Integer count, String sortParam);

    boolean checkForBadRequest(String sortParam);
}
