package com.aleksandr.blogca2023.repo;
import java.util.List;
import com.aleksandr.blogca2023.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByPriceLessThan(double price);
}