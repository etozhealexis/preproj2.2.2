package ru.etozhealexis.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.etozhealexis.springboot.dao.CarDao;
import ru.etozhealexis.springboot.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Value("${maxCar}")
    private int maxCount;

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars(Integer count) {
        if (count == null || maxCount <= count) {
            return carDao.getCars();
        }

        return carDao.getCars(count);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars(Integer count, String sortParam) {
        if (sortParam == null) {
            return listCars(count);
        }

        return carDao.getCars(count, sortParam);
    }

}
