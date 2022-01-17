package fr.yannm.annuaire.repository;

import fr.yannm.annuaire.model.company.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Billy Mortreux Yann Malaquin
 * @version 1.0
 * @name : CompanyRepository
 * @created 21/12/2021 - 14:53
 * @project Annuaire
 * @copyright Billy Mortreux Yann Malaquin
 **/
@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    // Permet de trouver une entreprise grâce à son ID
    Optional<Company> findById(Integer id);

    // Récupère toutes les entreprises
    List<Company> findAll();

    // Récupère une entreprise en fonction de son numéro de téléphone
    Optional<Company> findByPhone(String phone);
}
