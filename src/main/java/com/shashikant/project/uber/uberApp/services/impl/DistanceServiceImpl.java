package com.shashikant.project.uber.uberApp.services.impl;

import com.shashikant.project.uber.uberApp.services.DistanceService;
import lombok.Data;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL= "http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point source, Point destination) {

       try{
           String uri = source.getX()+","+source.getY()+";"+destination.getX()+","+destination.getY();
           ORSMResponseDto orsmResponseDto = RestClient.builder()
                   .baseUrl(OSRM_API_BASE_URL)
                   .build()
                   .get()
                   .uri(uri)
                   .retrieve()
                   .body(ORSMResponseDto.class);

           return orsmResponseDto.getRoutes().get(0).getDistance() /1000.0 ;
       } catch (Exception e){
           throw new RuntimeException("Error getting message from OSRM " + e.getMessage());
       }
    }
}

@Data
class ORSMResponseDto{

    private List<OSRMRoute> routes;

}

@Data
class OSRMRoute{
    private double distance;
}