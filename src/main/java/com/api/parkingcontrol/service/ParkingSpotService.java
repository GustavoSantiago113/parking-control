package com.api.parkingcontrol.service;

import com.api.parkingcontrol.domain.ParkingSpotModel;
import com.api.parkingcontrol.protocols.ParkingSpotInterface;
import com.api.parkingcontrol.repository.ParkingSpotRepository;
import com.api.parkingcontrol.request.ParkingSpotDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ParkingSpotService implements ParkingSpotInterface {

    final ParkingSpotRepository parkingSpotRepository;

    @Override
    public ResponseEntity<ParkingSpotDto> saveParking(ParkingSpotModel parkingSpotModel) {

        ParkingSpotModel spot1 = parkingSpotRepository.save(parkingSpotModel);
        ParkingSpotDto parkingSpotDto = ParkingSpotModel.fromDTO(spot1);
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotDto);
    }

    @Override
    public ResponseEntity<ParkingSpotModel> editParkingSpotModel(ParkingSpotModel parkingSpotModel){

        ParkingSpotModel parkEdited = parkingSpotRepository.save(parkingSpotModel);
        return ResponseEntity.status(HttpStatus.OK).body(parkEdited);
    }

    @Override
    public ResponseEntity<List<ParkingSpotModel>> listAllParkingSpotModel(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotRepository.findAll());
    }

    @Override
    public ResponseEntity<ParkingSpotModel> getParkingSpotModel(String responsibleName){
        Optional<ParkingSpotModel> parkingSpotModel = parkingSpotRepository.findByResponsibleName(responsibleName);
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModel.get());
    }

    @Override
    public ResponseEntity<ParkingSpotModel> deleteParkingSpotModel(String responsibleName){
        Optional<ParkingSpotModel> parkingSpotModel = parkingSpotRepository.findByResponsibleName(responsibleName);
        if(parkingSpotModel.isPresent()){
            parkingSpotRepository.delete(parkingSpotModel.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        @Override
        public ResponseEntity<ParkingSpotModel> editCar(String licensePlate,String brandCar,String modelCar,String colorCar){
            Optional<ParkingSpotModel> parkingSpotModel = parkingSpotRepository.findByResponsibleName(responsibleName);
            parkingSpotModel.get().setCar(modelCar);
            ParkingSpotModel user1 = parkingSpotRepository.save(parkingSpotModel.get());
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        }
    }
}
