package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelCustomers;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryModelMovies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdModelServiceSales {
    private Long customerId;
    private Long movieId;
    private Long quantityOfSales;
    private Date date;
    private float total;

}
