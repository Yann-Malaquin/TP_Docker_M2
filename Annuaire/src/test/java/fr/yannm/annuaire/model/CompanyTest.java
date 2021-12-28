package fr.yannm.annuaire.model;

import fr.yannm.annuaire.model.company.Company;
import fr.yannm.annuaire.model.person.Person;
import fr.yannm.annuaire.repository.CompanyRepository;
import fr.yannm.annuaire.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Yann
 * @version 1.0
 * @name : CompanyTest
 * @created 27/12/2021 - 17:41
 * @project Annuaire
 * @copyright Yann
 **/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyTest {

    @Autowired
    CompanyRepository companyRepository;

    @BeforeEach
    public void setup() {

        Company company = new Company();
        company.setId(2);
        company.setName("Nom1");
        company.setCountry("Pays");
        company.setPhone("0607080910");
        company.setCity("Ville1");
        company.setAddress("Adresse");
        company.setPersonRestList(new ArrayList<>());

        companyRepository.save(company);
    }

    @Test
    public void getCompanyAddress() {
        int id = 2;

        Optional<Company> companyOptional = companyRepository.findById(id);
        Company company = null;

        if (companyOptional.isPresent()) {
            company = companyOptional.get();
        }

        assertEquals(company.getAddress(), "Adresse");
    }
}
