package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterfaceCustomers;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterfaceMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvdStoreServiceCustomers {
    @Autowired
    private DvdStoreRepositoryInterfaceCustomers dvdStoreRepository;
}
