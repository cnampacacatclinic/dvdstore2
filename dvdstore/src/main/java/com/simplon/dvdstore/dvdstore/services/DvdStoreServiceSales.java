package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.controllers.*;
import com.simplon.dvdstore.dvdstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DvdStoreServiceSales {
    @Autowired
    private DvdStoreRepositoryInterfaceSales dvdStoreRepository;

    @Autowired
    private DvdStoreRepositoryInterfaceMovies dvdStoreRepositoryMovie;

    @Autowired
    private DvdStoreRepositoryInterfaceCustomers dvdStoreRepositoryCostumer;

    DvdStoreDtoIdMovies movieDto;
    DvdStoreDtoIdCustomers customerDto;

    //Insertion en BDD d'une vente
    public boolean save(DvdModelServiceSales sale) {
        //Nous avons besoin de l'id du film et de l'id du client
        //get() est utilisé ici parce que l'id est obtionnel il peut être null et le get va le récupérer
        DvdStoreRepositoryModelMovies movie = dvdStoreRepositoryMovie.findById(sale.getMovieId()).get();
        DvdStoreRepositoryModelCustomers customer = dvdStoreRepositoryCostumer.findById(sale.getCustomerId()).get();

        //on calcule le total
        float totalPrice= movie.getPrice() * sale.getQuantityOfSales();
        //sale.setTotal(totalPrice);

        //on modifie la quantité dans la table dvd
        long newDvdQuantity= movie.getQuantity()-sale.getQuantityOfSales();
        movie.setQuantity(newDvdQuantity);

        //Ici on est obligé de transformer notre model DTo en model repository
        DvdStoreRepositoryModelSales dvdStoreRepositoryModelSales = new DvdStoreRepositoryModelSales(
                //On redonne les données necessaires à construire notre vente
                customer, movie, sale.getQuantityOfSales(), sale.getDate(),totalPrice
        );



        //on retourne à la fonction sale du repository la vente construite ci-dessus
        //si ce n'est pas null, on affiche true
        return dvdStoreRepository.save(dvdStoreRepositoryModelSales) != null;
    }

    //afficher toutes les ventes
   public ArrayList<DvdStoreDtoSales> findAll() {
       ArrayList<DvdStoreRepositoryModelSales> salesList = dvdStoreRepository.findAll();
        ArrayList<DvdStoreDtoSales> salesDtoList = new ArrayList<>();

        for(DvdStoreRepositoryModelSales ee : salesList){
            DvdStoreDtoSales salesDto = new DvdStoreDtoSales(ee.getFKUsers().getId(),ee.getFKMovies().getId(), ee.getQuantityOfSales(), ee.getDate(),ee.getTotal());
            salesDtoList.add(salesDto);
        }

        return salesDtoList;/**/
    }

    // Supprimer un DVD par son ID
    public boolean delete(long id){
        dvdStoreRepository.deleteById(id);
        //pour renvoyer true dans la console
        return true;
    }

    public boolean updateSale(Long id, DvdModelServiceSales sale) {

        DvdStoreRepositoryModelSales ee = dvdStoreRepository.findById(id).get();
        //on obtient le client et le dvd par leur id
        DvdStoreRepositoryModelMovies movie = dvdStoreRepositoryMovie.findById(sale.getMovieId()).get();
        DvdStoreRepositoryModelCustomers customer = dvdStoreRepositoryCostumer.findById(sale.getCustomerId()).get();

        // on set les données
        ee.setQuantityOfSales(sale.getQuantityOfSales());
        ee.setFKUsers(customer);
        ee.setFKMovies(movie);
        ee.setDate(sale.getDate());

        // on enregistre
        dvdStoreRepository.save(ee);

        return true; //true si réussi
    }

    public DvdStoreRepositoryModelSales findById(Long id) {
        //le orElse c'est parce que l'identifiant n'existe peut-être pas
        return dvdStoreRepository.findById(id).orElse(null);
    }

    
}
