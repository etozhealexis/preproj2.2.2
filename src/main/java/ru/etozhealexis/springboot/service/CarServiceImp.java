package ru.etozhealexis.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.etozhealexis.springboot.dao.CarDao;
import ru.etozhealexis.springboot.model.Car;
import ru.etozhealexis.springboot.properties.CarProperties;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private  CarDao carDao;

    @Autowired
    private CarProperties carProperties;

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars(Integer count) {
        if (count == null || carProperties.getMaxCar() <= count) {
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

        if (count == null || carProperties.getMaxCar() <= count) {
            return carDao.getCars(sortParam);
        }

        return carDao.getCars(count, sortParam);
    }

    @Override
    public boolean validateSortParam(String sortParam) {
        return sortParam != null && !carProperties.getSortParams().contains(sortParam);
    }
}
