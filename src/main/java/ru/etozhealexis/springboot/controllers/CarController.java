package ru.etozhealexis.springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.etozhealexis.springboot.dao.CarDaoImp;

@Controller
public class CarController {
    private final CarDaoImp carDao;

    @Autowired
    public CarController(CarDaoImp carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(name="count", required=false, defaultValue="10") int count, Model model) {
        model.addAttribute("count", carDao.showCars(count));
        return "cars";
    }
}
