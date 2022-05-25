package com.api.parkingcontrol.repository;

import com.api.parkingcontrol.domain.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, Integer> {


    Optional<ParkingSpotModel> findByResponsibleName(String responsibleName);
}
