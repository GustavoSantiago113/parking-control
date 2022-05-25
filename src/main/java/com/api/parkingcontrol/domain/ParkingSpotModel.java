package com.api.parkingcontrol.domain;

import com.api.parkingcontrol.request.ParkingSpotDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_PARKING_SPOT")
@ToString

public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true, length = 10, name="spot_number")
    private Integer parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 15, name="license_plate")
    private String licensePlateCar;

    @Column(nullable = false, length = 70, name="brand_car")
    private String brandCar;

    @Column(nullable = false, length = 70, name="model_car")
    private String modelCar;

    @Column(nullable = false, length = 70, name="color_car")
    private String colorCar;

    @Column(nullable = false, name="registration_date")
    private LocalDate registrationDate;

    @Column(nullable = false, length = 130, name="responsible_name")
    private String responsibleName;

    @Column(nullable = false, unique=true, length = 30, name="apartment")
    private Integer apartment;

    @Column(nullable = false, length = 30, name="block")
    private Integer block;


    public static ParkingSpotDto fromDTO(ParkingSpotModel parkingSpotModel){

        return ParkingSpotDto.builder()
                .apartment(parkingSpotModel.getApartment())
                .block(parkingSpotModel.getBlock())
                .responsibleName(parkingSpotModel.getResponsibleName()).build();
    }

}
