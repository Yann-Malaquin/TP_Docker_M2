package fr.yannm.annuaire.model.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yann
 * @version 1.0
 * @name : UpdatePerson
 * @created 08/12/2021 - 11:15
 * @project Annuaire
 * @copyright Yann
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePerson {

    private String name;
    private String surname;
    private String phone;
    private String city;
}
