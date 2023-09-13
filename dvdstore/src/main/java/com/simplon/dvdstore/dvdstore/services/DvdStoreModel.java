package com.simplon.dvdstore.dvdstore.services;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class DvdStoreModel {
    List<DvdModelService> dvds = new ArrayList<>();

    public DvdStoreModel() {
    }
    public DvdStoreModel(List<DvdModelService> dvds) {
        this.dvds = dvds;
    }

}
