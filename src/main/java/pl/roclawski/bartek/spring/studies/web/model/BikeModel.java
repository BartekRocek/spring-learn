package pl.roclawski.bartek.spring.studies.web.model;

public class BikeModel {
    private Long id;
    private String name;
    private String make;
    private int year;

    public BikeModel() {
    }

    public BikeModel(Long id, String name, String make, int year) {
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
        return "BikeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                '}';
    }
}
