package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.controllers.DvdStoreDtoCustomers;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterfaceCustomers;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelCustomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DvdStoreServiceCustomers {
    @Autowired
    private DvdStoreRepositoryInterfaceCustomers dvdStoreRepository;

    //Insertion en BDD d'un client
    public DvdStoreRepositoryModelCustomers save(DvdStoreRepositoryModelCustomers customer) {
        return dvdStoreRepository.save(customer);
    }

    //Affichage de tous les clients
    public ArrayList<DvdStoreDtoCustomers> findAll() {
        ArrayList<DvdStoreRepositoryModelCustomers> customerList = dvdStoreRepository.findAll();
        ArrayList<DvdStoreDtoCustomers> customersList = new ArrayList<>();

        for(DvdStoreRepositoryModelCustomers customer : customerList){
            DvdStoreDtoCustomers customersDto = new DvdStoreDtoCustomers(customer.getFirstName(), customer.getLastName(), customer.getMail(),customer.getPhoneNumber(),customer.getStreetNumber(),customer.getStreetName(), customer.getPostcode(),customer.getCity(),customer.getVoie());
        }

        return customersList;
    }

}
