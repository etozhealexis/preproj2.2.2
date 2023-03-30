package ru.etozhealexis.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.etozhealexis.springboot.dao.CarDao;
import ru.etozhealexis.springboot.model.Car;

import java.util.List;

@Service
@PropertySource("classpath:application.properties")
public class CarServiceImp implements CarService {
    private final CarDao carDao;

    //    @Value("${maxCar}")
    private final int maxCount;

    @Autowired
    public CarServiceImp(Environment env, CarDao carDao) {
        maxCount = Integer.parseInt(env.getProperty("maxCar"));
        this.carDao = carDao;
    }

//    public CarServiceImp(Environment env) {
//        this.env = env;
////        maxCount = Integer.parseInt(env.getProperty("maxCar"));
//    }

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
