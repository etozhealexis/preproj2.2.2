package ru.etozhealexis.springboot.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.etozhealexis.springboot.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CarDaoImp implements CarDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Car> showCars(int count) {
        List<Car> allCars = sessionFactory.getCurrentSession().createQuery("FROM Car").getResultList();

//        for (Car car : allCars) {
//            System.out.println(car.getModel() + " " + car.getSeries());
//        }
        return allCars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
