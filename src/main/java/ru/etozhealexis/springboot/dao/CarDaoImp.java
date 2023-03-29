package ru.etozhealexis.springboot.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.etozhealexis.springboot.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private EntityManager entityManager;

    @Value("${maxCar}")
    private int maxCount;

    @SuppressWarnings("unchecked")
    public List<Car> showCars(int count) {
        List<Car> allCars = entityManager.createQuery("SELECT c FROM Car c").getResultList();

        if (maxCount < count) {
            count = maxCount;
        }

        return allCars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
