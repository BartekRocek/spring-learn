package pl.roclawski.bartek.spring.studies.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "BIKES")
public class BikeEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String make;
    @Column(name = "YEAR_MADE")
    private int year;

    public BikeEntity() {
    }

    public BikeEntity(Long id, String name, String make, int year) {
        this.id = id;
        this.name = name;
        this.make = make;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "BikeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                '}';
    }
}
