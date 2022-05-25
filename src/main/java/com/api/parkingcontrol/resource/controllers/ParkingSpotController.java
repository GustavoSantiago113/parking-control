package com.api.parkingcontrol.resource.controllers;

import com.api.parkingcontrol.domain.ParkingSpotModel;
import com.api.parkingcontrol.protocols.ParkingSpotInterface;
import com.api.parkingcontrol.request.ParkingSpotDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/parking-spot")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class ParkingSpotController {

    final ParkingSpotInterface parkingSpotInterface;

    //POST
    @PostMapping
    @CrossOrigin
    @RequestMapping("/new")
    public ResponseEntity<ParkingSpotDto> save(@RequestBody ParkingSpotModel parkingSpotModel){
        return parkingSpotInterface.saveParking (parkingSpotModel);
    }

    @PostMapping
    @CrossOrigin
    @RequestMapping("/edit")
    public ResponseEntity<ParkingSpotModel> edit(@RequestBody ParkingSpotModel parkingSpotModel){
        return parkingSpotInterface.editParkingSpotModel(parkingSpotModel);
    }

    @CrossOrigin
    @GetMapping
    @RequestMapping("/list-all")
    public ResponseEntity<List<ParkingSpotModel>> listParkingSpotModel(){
        return parkingSpotInterface.listAllParkingSpotModel();
    }

    @CrossOrigin
    @GetMapping
    @RequestMapping("/get-one/{responsibleName}")
    public ResponseEntity<ParkingSpotModel> getParkingSpotModel(@PathVariable(name = "responsibleName") String responsibleName){
        return parkingSpotInterface.getParkingSpotModel(responsibleName);
    }

    @CrossOrigin
    @GetMapping
    @RequestMapping("/delete/{responsibleName}")
    public ResponseEntity<ParkingSpotModel> delParkingSpotModel(@PathVariable(name = "responsibleName") String responsibleName){

        return parkingSpotInterface.deleteParkingSpotModel(responsibleName);
    }

    @CrossOrigin
    @PatchMapping
    @RequestMapping("/car")
    public ResponseEntity<ParkingSpotModel> edit(@RequestParam(name = "licensePlate") String licensePlate,
                                     @RequestParam(name = "brandCar") String brandCar,
                                     @RequestParam(name = "modelCar") String modelCar,
                                     @RequestParam(name = "colorCar") String colorCar,
                                                 @RequestParam(name= "responsibelName")String responsibleName){
        return parkingSpotInterface.editCar(licensePlate,brandCar,modelCar,colorCar, responsibleName);
    }
}
