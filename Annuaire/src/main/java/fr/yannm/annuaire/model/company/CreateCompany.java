package fr.yannm.annuaire.model.company;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Billy Mortreux Yann Malaquin
 * @version 1.0
 * @name : CreateCompany
 * @created 14/12/2021 - 16:41
 * @project Annuaire
 * @copyright Billy Mortreux Yann Malaquin
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Api(hidden = true)
public class CreateCompany {
    private String name;
    private String phone;
    private String address;
    private String city;
    private String country;
}
