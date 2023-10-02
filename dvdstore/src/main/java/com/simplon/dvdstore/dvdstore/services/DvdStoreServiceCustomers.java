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

        /*for(DvdStoreRepositoryModelCustomers customer : customerList){
            DvdStoreDtoCustomers customersDto = new DvdStoreDtoCustomers(customer.getFirstName(), customer.getLastName(), customer.getMail(),customer.getPhoneNumber(),customer.getStreetNumber(),customer.getStreetName(), customer.getPostcode(),customer.getCity(),customer.getVoie());
        }/**/
        for (DvdStoreRepositoryModelCustomers customer : customerList) {
            DvdStoreDtoCustomers customersDto = new DvdStoreDtoCustomers(
                    customer.getId(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getMail(),
                    customer.getPhoneNumber(),
                    customer.getStreetNumber(),
                    customer.getStreetName(),
                    customer.getPostcode(),
                    customer.getCity(),
                    customer.getVoie()
            );
            customersList.add(customersDto); // Ajoutez le client à la liste
        }


        return customersList;
    }

    public boolean updateById(Long id, DvdModelServiceCustomers customer) {
        //Service a reçu un DTO de la part du controller
        //Le repository permet d'obtenir les models getters  setters etc..
        if (id != null) {
            DvdStoreRepositoryModelCustomers customer2 = dvdStoreRepository.findById(id).orElse(null);
            if(customer2!=null)
            {
                //les parametres entre les parentheses du new customerStoreRepositoryModel, ceux sont les mutatteurs du model de service
                DvdStoreRepositoryModelCustomers customerStoreRepositoryModel = new DvdStoreRepositoryModelCustomers(id,customer.getFirstName(),customer.getLastName(),customer.getMail(),customer.getPhoneNumber(),customer.getStreetNumber(),customer.getStreetName(),customer.getPostcode(),customer.getCity(),customer.getVoie());
                var x = dvdStoreRepository.save(customerStoreRepositoryModel);
                if(x!=null) {
                    return true;
                }else {
                    return false;
                }
            }
        }else {
            return false;
        }
        return false;
    }
    // Obtenir un customer par son ID
    public DvdStoreRepositoryModelCustomers findById(Long id) {
        //le orElse c'est parce que l'identifiant n'existe peut-être pas
        return dvdStoreRepository.findById(id).orElse(null);
    }

}
