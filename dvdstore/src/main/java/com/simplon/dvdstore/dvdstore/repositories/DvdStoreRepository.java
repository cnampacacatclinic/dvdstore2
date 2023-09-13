package com.simplon.dvdstore.dvdstore.repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Entity
public class DvdStoreRepository implements DvdStoreRepositoryInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String genre;
    String name;

    public DvdStoreRepository() {
    }

    public DvdStoreRepository(int id) {
        this.id = id;
    }

    public DvdStoreRepository(String genre, String name) {
        this.genre = genre;
        this.name = name;
    }


    @Override
    public List<DvdStoreRepositoryModel> findById(int id) {
        return null;
    }

    @Override
    public <S extends DvdStoreRepositoryModel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DvdStoreRepositoryModel> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DvdStoreRepositoryModel> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<DvdStoreRepositoryModel> findAll() {
        return null;
    }

    @Override
    public Iterable<DvdStoreRepositoryModel> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(DvdStoreRepositoryModel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DvdStoreRepositoryModel> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
