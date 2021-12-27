package fr.yannm.annuaire.model.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.yannm.annuaire.model.company.Company;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

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
@ApiModel(value = "Person", description = "Entité qui caractérise une personne.")
public class Person {

    @Id
    @GeneratedValue
    @ApiModelProperty(" L'id de la personne.")
    private int id;

    @ApiModelProperty("Le nom de la personne.")
    private String name;

    @ApiModelProperty("Le prénom de la personne.")
    private String surname;

    @ApiModelProperty("Le numéro de téléphone de la personne.")
    private String phone;

    @ApiModelProperty("La ville de la personne.")
    private String city;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties({ "personRestList" })
    @ApiModelProperty(value = "L'entreprise de la personne.", required = false)
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
