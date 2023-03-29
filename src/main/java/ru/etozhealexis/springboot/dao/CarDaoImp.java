package ru.etozhealexis.springboot.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.etozhealexis.springboot.model.Car;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Car> getCars() {
        List<Car> allCars = entityManager.createQuery("SELECT c FROM Car c").getResultList();

        return entityManager.createQuery("SELECT c FROM Car c").getResultList();
    }
}
