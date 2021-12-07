package fr.yannm.annuaire.model;

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

    private String name;
    private String surname;
    private String phone;
    private String city;
}
