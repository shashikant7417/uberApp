package com.shashikant.project.uber.uberApp.dtos;

import lombok.*;

@Data
@NoArgsConstructor

public class PointDto {

    private double[] coordinates;
    private String type = "Point";


    public PointDto(double[] coordinates) {
        this.coordinates = coordinates;
    }


}
