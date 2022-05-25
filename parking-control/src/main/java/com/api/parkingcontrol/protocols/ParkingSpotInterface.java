package com.api.parkingcontrol.protocols;

import com.api.parkingcontrol.domain.ParkingSpotModel;
import com.api.parkingcontrol.request.ParkingSpotDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkingSpotInterface {

    ResponseEntity<ParkingSpotDto> saveParking(ParkingSpotModel parkingSpotModel);

    ResponseEntity<ParkingSpotModel> editParkingSpotModel(ParkingSpotModel parkingSpotModel);

    ResponseEntity<List<ParkingSpotModel>> listAllParkingSpotModel();

    ResponseEntity<ParkingSpotModel> getParkingSpotModel(String responsibleName);

    ResponseEntity<ParkingSpotModel> deleteParkingSpotModel(String responsibleName);
}
