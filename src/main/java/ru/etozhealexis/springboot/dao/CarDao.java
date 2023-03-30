package ru.etozhealexis.springboot.dao;

import ru.etozhealexis.springboot.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCars();

    List<Car> getCars(int count);

    List<Car> getCars(int count, String sortParam);

    List<Car> getCars(String sortParam);
}
