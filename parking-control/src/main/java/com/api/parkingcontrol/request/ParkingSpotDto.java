package com.api.parkingcontrol.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class ParkingSpotDto {

    private String responsibleName;
    private Integer apartment;
    private Integer block;

}
