package ru.etozhealexis.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.etozhealexis.springboot.dao.CarDao;
import ru.etozhealexis.springboot.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Value("${maxCar}")
    private int maxCount;

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCarsLimited(Integer count) {
        count = (count != null) && maxCount <= count ? null : count;
        return count == null ? carDao.getCars() :
                carDao.getCarsLimited(count);
    }

}
