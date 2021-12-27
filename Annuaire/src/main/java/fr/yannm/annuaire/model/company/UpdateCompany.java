package fr.yannm.annuaire.model.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yann
 * @version 1.0
 * @name : UpdateCompany
 * @created 14/12/2021 - 16:41
 * @project Annuaire
 * @copyright Yann
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompany {
    private String name;
    private String phone;
    private String address;
    private String city;
    private String country;
}
