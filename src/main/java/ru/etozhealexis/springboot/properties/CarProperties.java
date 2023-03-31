package ru.etozhealexis.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "car")
public class CarProperties {
    private int maxCar;

    private List<String> sortParams;

    public int getMaxCar() {
        return maxCar;
    }

    public List<String> getSortParams() {
        return sortParams;
    }

    public void setMaxCar(int maxCar) {
        this.maxCar = maxCar;
    }

    public void setSortParams(List<String> sortParams) {
        this.sortParams = sortParams;
    }
}
