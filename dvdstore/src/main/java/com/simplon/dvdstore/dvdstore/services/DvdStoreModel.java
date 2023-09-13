package com.simplon.dvdstore.dvdstore.services;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class DvdStoreModel {
    List<DvdModel> dvds = new ArrayList<>();

    public DvdStoreModel() {
    }
    public DvdStoreModel(List<DvdModel> dvds) {
        this.dvds = dvds;
    }

}
