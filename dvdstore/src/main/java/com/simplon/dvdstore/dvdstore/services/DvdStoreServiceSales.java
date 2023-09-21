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
    //public DvdStoreRepositoryModelSales save(DvdStoreDtoSales sale) {
    public DvdStoreRepositoryModelSales save(DvdStoreRepositoryModelSales sale) {
        return dvdStoreRepository.save(sale);
    }

    /*public DvdStoreRepositoryModelSales save2(DvdStoreDtoSales sale,DvdStoreDtoIdMovies movieDto,DvdStoreDtoIdCustomers customerDto) {
        return dvdStoreRepository.save(sale.quantityOfSales(),movieDto.id(),customerDto.id());
    }/**/

    //public DvdStoreRepositoryModelSales addSale(DvdStoreDtoSales sale) {
        //DvdStoreRepositoryModelSales newSale = new DvdStoreRepositoryModelSales(sale.FKUsers(),sale.FKMovies(),sale.quantityOfSales(),sale.date());

        //return dvdStoreRepository.save(newSale);
    //}

    //afficher toutes les ventes
   public ArrayList<DvdStoreDtoSales> findAll() {
        ArrayList<DvdStoreRepositoryModelSales> salesList = dvdStoreRepository.findAll();
        ArrayList<DvdStoreDtoSales> salesDtoList = new ArrayList<>();

        for(DvdStoreRepositoryModelSales ee : salesList){
            DvdStoreDtoSales salesDto = new DvdStoreDtoSales(ee.getFKUsers(),ee.getFKMovies(),ee.getQuantityOfSales(), ee.getDate());
            salesDtoList.add(salesDto);
        }

        return salesDtoList;
    }

    // Supprimer un DVD par son ID
    public boolean delete(long id){
        dvdStoreRepository.deleteById(id);
        //pour renvoyer true dans la console
        return true;
    }
}
