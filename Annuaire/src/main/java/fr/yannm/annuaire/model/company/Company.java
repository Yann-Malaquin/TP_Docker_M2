package fr.yannm.annuaire.model.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.yannm.annuaire.model.person.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author Billy Mortreux Yann Malaquin
 * @version 1.0
 * @name : Company
 * @created 14/12/2021 - 16:33
 * @project Annuaire
 * @copyright Billy Mortreux Yann Malaquin
 **/
@Entity
@Table(name = "company")
@NoArgsConstructor
@Getter
@Setter
@ApiModel(value = "Company", description = "Entité qui caractérise une entreprise.")
public class Company {

    @Id
    @GeneratedValue
    @ApiModelProperty("L'id de l'entreprise.")
    private int id;

    @ApiModelProperty("Le nom de l'entreprise.")
    private String name;

    @ApiModelProperty("Le numéro de téléphone de l'entreprise.")
    private String phone;

    @ApiModelProperty("L'adresse de l'entreprise.")
    private String address;

    @ApiModelProperty("La ville de l'entreprise.")
    private String city;

    @ApiModelProperty("Le pays de l'entreprise.")
    private String country;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"company"})
    @ApiModelProperty("La liste des personnes de l'entreprise.")
    private List<Person> personRestList;


    public Company(String name, String phone, String address, String city, String country) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
    }
}
