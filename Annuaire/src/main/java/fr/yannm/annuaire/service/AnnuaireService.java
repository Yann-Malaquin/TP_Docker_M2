package fr.yannm.annuaire.service;


import fr.yannm.annuaire.model.company.Company;
import fr.yannm.annuaire.model.company.CreateCompany;
import fr.yannm.annuaire.model.company.UpdateCompany;
import fr.yannm.annuaire.model.person.CreatePerson;
import fr.yannm.annuaire.model.person.Person;
import fr.yannm.annuaire.model.person.UpdatePerson;
import fr.yannm.annuaire.repository.CompanyRepository;
import fr.yannm.annuaire.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Yann
 * @version 1.0
 * @name : Annuaire
 * @created 22/11/2021 - 16:01
 * @project Annuaire
 * @copyright Yann
 **/
@Service(value = "annuaire")
public class AnnuaireService implements AnnuaireItf {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public ResponseEntity<?> createPersons() {
        Person person = new Person("Michel", "Jean", "0606060606", "Lille");
        personRepository.save(person);
        person = new Person("Claude", "Jean", "0606060606", "Valenciennes");
        personRepository.save(person);
        person = new Person("Jeannette", "Micheline", "0606060606", "Paris");
        personRepository.save(person);


        return ResponseEntity.ok("Personnes ajoutées");
    }

    @Override
    public Map<String, Person> getPersons() {
        // Initialisation de la map
        Map<String, Person> personMap = new HashMap<>();

        // Initialisation de la liste et récupération des personnes
        List<Person> personList = new ArrayList<>();
        personList.addAll(personRepository.findAll());

        // Insertion des personnes dans la map
        for (Person p : personList) {
            personMap.put(String.valueOf(p.getId()), p);
        }

        return personMap;
    }

    @Override
    public Person findById(int id) {

        // Initialisation de la map
        Map<String, Person> personMap = new HashMap<>();

        //  Récupération de la personne
        Optional<Person> p = personRepository.findById(id);

        // Si une personne de cet id est présente
        if (p.isPresent()) {
            return p.get();
        }

        return null;
    }

    @Override
    public Map<String, Person> findByName(String name) {
        // Initialisation de la map
        Map<String, Person> personMap = new HashMap<>();


        // Initialisation de la liste et récupération des personnes
        List<Person> personList = new ArrayList<>();
        personList.addAll(personRepository.findAllByName(name));

        // Insertion des personnes dans la map
        for (Person p : personList) {
            personMap.put(String.valueOf(p.getId()), p);
        }

        return personMap;
    }


    @Override
    public Person addPerson(String name, String surname, String phone, String city) {

        Person person = new Person(name, surname, phone, city);
        personRepository.save(person);

        return person;
    }

    @Override
    public void deletePerson(int id) {

        Optional<Person> p = personRepository.findById(id);

        if (p.isPresent()) {
            personRepository.delete(p.get());
        }
    }

    @Override
    public Person updatePerson(String id, String name, String surname, String phone, String city) {
        // Récupération de la personne depuis son ID
        Optional<Person> p = personRepository.findById(Integer.parseInt(id));
        Person toUpdate = null;
        // Si la personne a été trouvé
        if (p.isPresent()) {
            System.out.println(toUpdate);
            toUpdate = p.get();
            toUpdate.setId(Integer.parseInt(id));
            toUpdate.setName(name);
            toUpdate.setSurname(surname);
            toUpdate.setPhone(phone);
            toUpdate.setCity(city);
            personRepository.save(toUpdate);
        }


        return toUpdate;
    }

    @Override
    public ResponseEntity<?> getPersonsRest() {

        if (!personRepository.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(personRepository.findAll());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Liste vide");
    }

    @Override
    public ResponseEntity<?> createPersonRest(CreatePerson createPerson) {

        // Récupération de la personne par son numéro de téléphone
        Optional<Person> person = personRepository.findByPhone(createPerson.getPhone());
        // Récupération de l'entreprise grâce à son ID
        Optional<Company> companyOptional = companyRepository.findById(createPerson.getCompany_id());
        Company company = null;

        // Si l'on a récupéré une personne alors cela signifie que l'on ne peut pas en créer une nouvelle
        if (person.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Personne déjà existante");
        }

        if (companyOptional.isPresent()) {
            company = companyOptional.get();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(new Person(
                        createPerson.getName(),
                        createPerson.getSurname(),
                        createPerson.getPhone(),
                        createPerson.getCity(),
                        company
                )
        ));
    }

    @Override
    public ResponseEntity<?> deletePersonRest(int id) {
        Optional<Person> p = personRepository.findById(id);

        if (p.isPresent()) {
            personRepository.delete(p.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Override
    public ResponseEntity<?> findByIdRest(int id) {

        Optional<Person> p = personRepository.findById(id);

        if (p.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(p.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Override
    public ResponseEntity<?> updatePersonRest(int id, UpdatePerson updatePerson) {
        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()) {
            Person p = person.get();
            p.setName(updatePerson.getName());
            p.setSurname(updatePerson.getSurname());
            p.setPhone(updatePerson.getPhone());
            p.setCity(updatePerson.getCity());

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personRepository.save(p));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<?> findPersonRest(String name) {

        List<Person> personList = personRepository.findAllByName(name);

        if (personList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(personList);

    }

    @Override
    public ResponseEntity<?> createCompany(CreateCompany createCompany) {

        Optional<Company> company = companyRepository.findByPhone(createCompany.getPhone());

        if (company.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Entreprise déjà existante");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(companyRepository.save(new Company(
                        createCompany.getName(),
                        createCompany.getPhone(),
                        createCompany.getAddress(),
                        createCompany.getCity(),
                        createCompany.getCountry()
                )
        ));
    }

    @Override
    public ResponseEntity<?> getCompany() {

        if (!companyRepository.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(companyRepository.findAll());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Liste vide");
    }

    @Override
    public ResponseEntity<?> deleteCompany(int id) {
        Optional<Company> company = companyRepository.findById(id);

        if (company.isPresent()) {
            companyRepository.delete(company.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Override
    public ResponseEntity<?> findCompanyById(int id) {
        Optional<Company> company = companyRepository.findById(id);


        if (company.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(company.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<?> updateCompany(int id, UpdateCompany updateCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setName(updateCompany.getName());
            company.setPhone(updateCompany.getPhone());
            company.setAddress(updateCompany.getAddress());
            company.setCity(updateCompany.getCity());
            company.setCountry(updateCompany.getCountry());

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(companyRepository.save(company));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
