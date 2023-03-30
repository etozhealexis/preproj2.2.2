package ru.etozhealexis.springboot.dao;

import ru.etozhealexis.springboot.model.Car;

import java.util.List;

public interface CarDao {
    public List<Car> getCars();

    public List<Car> getCars(int count);

    List<Car> getCars(Integer count, String sortParam);
}
