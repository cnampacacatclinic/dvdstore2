package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DvdStoreRepositoryInterfaceSales extends CrudRepository<DvdStoreRepositoryModelSales,Long> {
    ArrayList<DvdStoreRepositoryModelSales> findAll();
    //DvdStoreRepositoryModelSales save(DvdStoreRepositoryModelSales sale, Long id, Long id1);
}
