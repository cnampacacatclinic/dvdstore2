package com.dvdstore.panier.services;

import com.dvdstore.panier.repositories.PanierRepositoryInterface;
import com.dvdstore.panier.repositories.PanierRepositoryModel;
import com.dvdstore.panier.controllers.PanierDtoId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PanierService {
    @Autowired
    private PanierRepositoryInterface panierRepositoryInterface;

    //Pour les procedures stockées
    private final JdbcTemplate jdbcTemplate;

    @Autowired  // Injection de l'instance de JdbcTemplate
    public PanierService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public boolean total() {
        // On utilise jdbcTemplate pour appeler la procédure stockée PostgreSQL
        jdbcTemplate.execute("CALL public.total()");
        return true;
    }

    public boolean supppanier() {
        jdbcTemplate.execute("CALL public.supppanier()");
        return true;
    }

    public boolean solde(float poucent) {
        jdbcTemplate.execute("CALL public.solde(poucent)");
        return true;
    }

    //select par id dans le panier
    public PanierRepositoryModel findById(Integer id) {
        return panierRepositoryInterface.findById(id).orElse(null);
    }

    // Insérer dans le panier
    public boolean save(PanierModelServiceID panierModelService) {
        try {
            // Créez une instance de PanierRepositoryModel en utilisant le constructeur
            PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(
                    panierModelService.getId_panier(),
                    panierModelService.getIdClient(),
                    panierModelService.getIdDvd(),
                    panierModelService.getPrixUnitaire(),
                    panierModelService.getTotal(),
                    panierModelService.getDate(),
                    panierModelService.getQuantity()
            );
            total();
            // Enregistrez l'objet dans la base de données en utilisant la méthode save()
            panierRepositoryInterface.save(panierRepositoryModel);
            return true;
        } catch (Exception e) {
            // Gérez l'exception ici, vous pouvez la logger ou renvoyer une réponse d'erreur
            e.printStackTrace(); // Loggez l'exception pour le débogage
            return false; // Vous pouvez renvoyer false ou une autre réponse d'erreur appropriée
        }
    }



    //Supprime par id dans le panier
    public boolean delete(Integer id) {
        panierRepositoryInterface.deleteById(id);
        return true;
    }

    //Update le panier
    public PanierRepositoryModel update(Integer id, PanierModelService panierModelService) {
        // Recherche l'élément dans la base de données par son ID
        return panierRepositoryInterface.findById(id)
                .map(panierRepositoryModel -> {
                    // Met à jour les propriétés avec les valeurs du modèle service
                    panierRepositoryModel.setIdClient(panierModelService.getIdClient());
                    panierRepositoryModel.setIdDvd(panierModelService.getIdDvd());
                    panierRepositoryModel.setPrixUnitaire(panierModelService.getPrixUnitaire());
                    panierRepositoryModel.setTotal(panierModelService.getTotal());
                    panierRepositoryModel.setQuantity(panierModelService.getQuantity());

                    // Enregistre dans la base de données et retourne le résultat
                    return panierRepositoryInterface.save(panierRepositoryModel);
                })
                .orElse(null);
    }


    public ArrayList<PanierDtoId> findAll() {
        ArrayList<PanierRepositoryModel> panierList = panierRepositoryInterface.findAll();
        ArrayList<PanierDtoId> paniersList = new ArrayList<>();

        for (PanierRepositoryModel attribut : panierList) {
            PanierDtoId panierDto = new PanierDtoId(attribut.getId_panier(),attribut.getIdClient(), attribut.getId_panier(), attribut.getPrixUnitaire(), attribut.getTotal(), attribut.getDate(), attribut.getQuantity());
            paniersList.add(panierDto); // Ajoutez le panierDto à la liste
        }

        return paniersList;
    }
}

