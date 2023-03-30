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
        return entityManager.createQuery("SELECT c FROM Car c").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> getCarsLimited(int count) {
        try {
            return entityManager.createQuery("SELECT c FROM Car c").setMaxResults(count).getResultList();
        } catch (IllegalArgumentException e) {
            return entityManager.createQuery("SELECT c FROM Car c").setMaxResults(0).getResultList();
        }

    }
}
