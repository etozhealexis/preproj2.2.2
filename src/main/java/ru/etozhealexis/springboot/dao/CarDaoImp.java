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
    public List<Car> getCars(int count) {
        if (count < 0) {
            return entityManager.createQuery("SELECT c FROM Car c").setMaxResults(0).getResultList();
        }

        return entityManager.createQuery("SELECT c FROM Car c").setMaxResults(count).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> getCars(Integer count, String sortParam) {
        if (count < 0) {
            return getCars(count);
        }

        return entityManager.createQuery("SELECT c FROM Car c ORDER BY (:sortParam)")
                .setParameter("sortParam", sortParam)
                .setMaxResults(count)
                .getResultList();
    }
}
