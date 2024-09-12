package com.aleksandr.blogca2023.repo;


import com.aleksandr.blogca2023.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

    //List<Parking> findByModel(String parkingModel);
   // @Query("SELECT t FROM Parking t WHERE t.model LIKE %?1%"
     //       + " OR CONCAT(t.plate, '') LIKE %?1%")
    //List<Parking> findParkingsByKeyword(String keyword);



     List<Parking> findByModel(String parkingModel);
      @Query("SELECT p FROM Parking p WHERE p.model LIKE %?1%"
            + " OR p.plate LIKE %?1%"
            + " OR p.space LIKE %?1%"
            + " OR p.model LIKE %?1%"

      )
     List<Parking> findParkingsByKeyword(String keyword);


}