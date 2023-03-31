package ru.etozhealexis.springboot.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.etozhealexis.springboot.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Car> getCars() {
        return entityManager.createQuery("SELECT c FROM Car c")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> getCars(int count) {
        if (count <= 0) {
            return new ArrayList<>();
        }

        return entityManager.createQuery("SELECT c FROM Car c")
                .setMaxResults(count)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> getCars(int count, String sortParam) {
        if (count <= 0) {
            return new ArrayList<>();
        }

        StringBuilder queryStr = new StringBuilder("SELECT c FROM Car c ORDER BY c.");
        queryStr.append(sortParam);
        return entityManager.createQuery(queryStr.toString())
                .setMaxResults(count)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> getCars(String sortParam) {
        return entityManager.createQuery("SELECT c FROM Car c ORDER BY c." + sortParam)
                .getResultList();
    }
}
