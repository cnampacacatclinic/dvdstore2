package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.ManyToMany;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DvdStoreRepositoryInterfaceCustomers extends CrudRepository<DvdStoreRepositoryModelCustomers,Long> {

    ArrayList<DvdStoreRepositoryModelCustomers> findAll();
}
