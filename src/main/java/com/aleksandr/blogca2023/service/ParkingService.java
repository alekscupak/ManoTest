package com.aleksandr.blogca2023.service;

import com.aleksandr.blogca2023.entities.Parking;
import com.aleksandr.blogca2023.repo.ParkingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ParkingService {

    private ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    public Parking addNewParking(Parking newParking) {
        return parkingRepository.save(newParking);
    }

    public List<Parking> findParkingsByModel(String parkingModel) {
        return parkingRepository.findByModel(parkingModel);
    }

    public Parking getParking(Long id) {
        return parkingRepository.findById(id).get();
    }

    public List<Parking> filterParkingsByKeyword(String keyword) {
        return parkingRepository.findParkingsByKeyword(keyword);
    }
    public Page<Parking> findPaginated(Pageable pageable) {
        List<Parking> parkings = parkingRepository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Parking> list;

        if (parkings.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, parkings.size());
            list = parkings.subList(startItem, toIndex);
        }

        Page<Parking> ParkingPage = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), parkings.size());

        return ParkingPage;
    }

}