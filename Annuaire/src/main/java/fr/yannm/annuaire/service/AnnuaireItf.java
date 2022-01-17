package fr.yannm.annuaire.service;

import fr.yannm.annuaire.model.company.CreateCompany;
import fr.yannm.annuaire.model.company.UpdateCompany;
import fr.yannm.annuaire.model.person.CreatePerson;
import fr.yannm.annuaire.model.person.Person;
import fr.yannm.annuaire.model.person.UpdatePerson;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * @author Billy Mortreux Yann Malaquin
 * @version 1.0
 * @name : AnnuaireItf
 * @created 22/11/2021 - 15:56
 * @project Annuaire
 * @copyright Billy Mortreux Yann Malaquin
 **/
public interface AnnuaireItf {

    public ResponseEntity<?> createPersons();

    public Map<String, Person> getPersons();

    public Person findById(int id);

    public Map<String, Person> findByName(String name);

    public Person addPerson(String name, String surname, String phone, String city);

    public void deletePerson(int id);

    public Person updatePerson(String id, String name, String surname, String phone, String city);

    public ResponseEntity<?> getPersonsRest();

    public ResponseEntity<?> createPersonRest(CreatePerson createPerson);

    public ResponseEntity<?> deletePersonRest(int id);

    public ResponseEntity<?> findByIdRest(int id);

    public ResponseEntity<?> updatePersonRest(int id, UpdatePerson updatePerson);

    public ResponseEntity<?> findPersonRest(String name);

    public ResponseEntity<?> getCompany();

    public ResponseEntity<?> createCompany(CreateCompany createCompany);

    public ResponseEntity<?> deleteCompany(int id);

    public ResponseEntity<?> findCompanyById(int id);

    public ResponseEntity<?> updateCompany(int id, UpdateCompany updateCompany);


}
