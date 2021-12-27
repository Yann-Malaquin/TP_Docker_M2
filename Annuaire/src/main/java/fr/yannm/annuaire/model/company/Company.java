package fr.yannm.annuaire.model.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.yannm.annuaire.model.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Yann
 * @version 1.0
 * @name : Company
 * @created 14/12/2021 - 16:33
 * @project Annuaire
 * @copyright Yann
 **/
@Entity
@Table(name = "company")
@NoArgsConstructor
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phone;
    private String address;
    private String city;
    private String country;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"company"})
    private List<Person> personRestList;


    public Company(String name, String phone, String address, String city, String country) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
    }
}
