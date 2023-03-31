package ru.etozhealexis.springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.etozhealexis.springboot.service.CarService;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(name = "count", required = false) Integer count,
                       @RequestParam(name = "sortParam", required = false) String sortParam,
                       Model model) {
        if (carService.checkForBadRequest(sortParam)) {
            model.addAttribute("error", HttpStatus.BAD_REQUEST);
            return "error";
        }

        model.addAttribute("cars", carService.listCars(count, sortParam));
        return "cars";
    }
}
