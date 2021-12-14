package fr.yannm.annuaire.repository;

import fr.yannm.annuaire.model.person.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour les personnes
 *
 * @author Yann
 * @version 1.0
 * @name : PersonRepository
 * @created 08/11/2021 - 18:55
 * @project Annuaire
 * @copyright Yann
 **/
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    // Permet de trouver une personne grâce à son ID
    Optional<Person> findById(Integer id);

    // Récupère toutes les personnes
    List<Person> findAll();

    // Récupère une personne de nom name si elle existe
    List<Person> findAllByName(String name);

    // Récupère une personne en fonction de son numéro de téléphone
    Optional<Person> findByPhone(String phone);
}
