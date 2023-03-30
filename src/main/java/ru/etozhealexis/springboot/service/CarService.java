package ru.etozhealexis.springboot.service;

import ru.etozhealexis.springboot.model.Car;

import java.util.List;

public interface CarService {
    List<Car> listCarsLimited(Integer count);
}
