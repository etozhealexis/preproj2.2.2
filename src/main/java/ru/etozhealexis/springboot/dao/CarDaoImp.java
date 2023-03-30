package ru.etozhealexis.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.etozhealexis.springboot.model.Car;

import java.sql.PreparedStatement;
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
        return entityManager.createQuery("SELECT c FROM Car c").setMaxResults(count).getResultList();
    }
}
