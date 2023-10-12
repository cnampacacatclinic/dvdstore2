package com.dvdstore.panier.services;

import com.dvdstore.panier.repositories.PanierRepositoryInterface;
import com.dvdstore.panier.repositories.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanierService {
    @Autowired
    private PanierRepositoryInterface panierRepositoryInterface;

    //select par id dans le panier
    public PanierRepositoryModel findById(Long id) {
        return panierRepositoryInterface.findById(id).orElse(null);
    }

    // Insérer dans le panier
    public boolean save(PanierModelService panierModelService) {
        // On créait une instance de PanierRepositoryModel
        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel();

        //On affecte les valeurs de panierModelService dans panierRepositoryModel
        panierRepositoryModel.setIdClient(panierModelService.getIdClient());
        panierRepositoryModel.setIdDvd(panierModelService.getIdDvd());
        panierRepositoryModel.setPrixUnitaire(panierModelService.getPrixUnitaire());
        panierRepositoryModel.setTotal(panierModelService.getTotal());
        panierRepositoryModel.setQuantity(panierModelService.getQuantity());

        panierRepositoryInterface.save(panierRepositoryModel);
        return true;
    }

    //Supprime par id dans le panier
    public boolean delete(Long id) {
        panierRepositoryInterface.deleteById(id);
        return true;
    }

    //Update le panier
    public PanierRepositoryModel update(Long id, PanierModelService panierModelService) {
        PanierRepositoryModel panierRepositoryModel = panierRepositoryInterface.findById(id).orElse(null);
        //Si ce n'est null
        if (panierRepositoryModel != null) {
            panierRepositoryModel.setIdClient(panierModelService.getIdClient());
            panierRepositoryModel.setIdDvd(panierModelService.getIdDvd());
            panierRepositoryModel.setPrixUnitaire(panierModelService.getPrixUnitaire());
            panierRepositoryModel.setTotal(panierModelService.getTotal());
            panierRepositoryModel.setQuantity(panierModelService.getQuantity());

            // Enregistre dans la base de données
            return panierRepositoryInterface.save(panierRepositoryModel);
        } else {
            //Sinon ça nous renvoie null
            return null;
        }
    }

}

