package pl.roclawski.bartek.spring.learn.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class AccountEntity {    //by default table name
// Każde pole w klasie będzie kolumną w tabeli
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String department;


    public AccountEntity() {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

// TODO: 27.02.2023 Stworzyć nową własną encję mapującą klasę Java na tabelę
//  Stworzyć nowe repozytorium dla nowej encji
//  Napisać test jednostkowy dla repozytorium i nowej encji
//  Wzorując się na AccountEntity oraz AccountRepository plus AccountRepositoryTest
