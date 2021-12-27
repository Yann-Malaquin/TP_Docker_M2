package fr.yannm.annuaire.model.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.yannm.annuaire.model.company.Company;

import javax.persistence.*;

/**
 * Table person
 *
 * @author Yann
 * @version 1.0
 * @name : Person
 * @created 08/11/2021 - 18:46
 * @project Annuaire
 * @copyright Yann
 **/
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String city;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties({ "personRestList" })
    private Company company;

    public Person() {
    }

    public Person(String name, String surname, String phone, String city) {
        super();
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
    }

    public Person(String name, String surname, String phone, String city, Company company) {
        super();
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.company = company;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
