package ru.etozhealexis.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column()
    private String model;

    @Column()
    private int series;

    @Column()
    private String manufacturer;

    public Car() {
    }

    public Car(String model, int series, String manufacturer) {
        this.model = model;
        this.series = series;
        this.manufacturer = manufacturer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
