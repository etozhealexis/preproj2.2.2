package ru.etozhealexis.springboot.dao;

import ru.etozhealexis.springboot.model.Car;

import java.util.List;

public interface CarDao {
    public List<Car> showCars(int count);
}
