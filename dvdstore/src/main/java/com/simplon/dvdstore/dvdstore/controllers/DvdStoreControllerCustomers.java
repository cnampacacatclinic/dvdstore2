package com.simplon.dvdstore.dvdstore.controllers;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelCustomers;
import com.simplon.dvdstore.dvdstore.services.DvdModelServiceCustomers;
import com.simplon.dvdstore.dvdstore.services.DvdStoreServiceCustomers;
import com.simplon.dvdstore.dvdstore.services.ServiceMapper;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
//@RequestMapping("api/customer")
@RequestMapping("customer")
public class DvdStoreControllerCustomers {
    @Autowired
    private DvdStoreServiceCustomers dvdStoreService;

    private ServiceMapper serviceMapper;

    // Ajouter un nouveau client
    @PostMapping("/")
    public DvdStoreRepositoryModelCustomers addDvd(@RequestBody DvdStoreRepositoryModelCustomers customer) {
        return dvdStoreService.save(customer);
    }


    //Afficher tous les clients
    @GetMapping("/")
     public ArrayList<DvdStoreDtoCustomers> getAllCustomers() {
      return dvdStoreService.findAll();
    }/**/


    //Update
   /*@PutMapping("/{id}")
    public boolean updateCustomer(@PathVariable Long id, @RequestBody DvdStoreDtoIdCustomers customer){
        DvdModelServiceCustomers dvdModelService = new DvdModelServiceCustomers(id, customer.firstName(), customer.lastName(), customer.mail(), customer.phoneNumber(), customer.streetNumber(), customer.streetName(), customer.postcode(), customer.city(), customer.voie());
        return dvdStoreService.updateById(id,dvdModelService);
    }/**/

    //Update costumer
   @PutMapping("/{id}")
    public boolean updateCustomer(@PathVariable Long id, @RequestBody DvdStoreDtoIdCustomers customer) {
        DvdModelServiceCustomers customerServiceModel = ServiceMapper.INSTANCE.dtoIdToServiceCustomer(customer);
        return dvdStoreService.updateById(id, customerServiceModel);
    }/**/

    @GetMapping("/{id}")
    public DvdStoreRepositoryModelCustomers getDvdById(@PathVariable Long id){
        return dvdStoreService.findById(id);
    }

}
