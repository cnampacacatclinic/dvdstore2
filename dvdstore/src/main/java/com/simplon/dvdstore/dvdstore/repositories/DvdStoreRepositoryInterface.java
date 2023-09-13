package com.simplon.dvdstore.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DvdStoreRepositoryInterface extends CrudRepository<DvdStoreRepositoryModel,Long> {

    //List<DvdStoreRepositoryModel> findById(Long id);

    List<DvdStoreRepositoryModel> findById(int id);
}
