package com.simplon.dvdstore.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DvdStoreRepositoryInterfaceSales extends CrudRepository<DvdStoreRepositoryModelSales,Long> {
    ArrayList<DvdStoreRepositoryModelSales> findAll();
}
