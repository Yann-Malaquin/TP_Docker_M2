package fr.yannm.annuaire.model.person;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yann
 * @version 1.0
 * @name : CreatePerson
 * @created 07/12/2021 - 17:01
 * @project Annuaire
 * @copyright Yann
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePerson {

    @ApiModelProperty("Le nom de la personne.")
    private String name;
    @ApiModelProperty("Le prénom de la personne.")
    private String surname;
    @ApiModelProperty("Le numéro de téléphone de la personne.")
    private String phone;
    @ApiModelProperty("La ville de la personne.")
    private String city;
    @ApiModelProperty("L'id de l'entreprise rattachée.")
    private int company_id;

}
