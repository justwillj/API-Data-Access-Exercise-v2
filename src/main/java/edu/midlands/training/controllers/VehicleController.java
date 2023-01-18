package edu.midlands.training.controllers;

import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.services.VehicleService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

  @Autowired
  private VehicleService vehicleService;

  //TEST
  @GetMapping(value = "/vehicles")
  public List<Vehicle>getVehicles(){
    return vehicleService.getVehicles();
  }

  @GetMapping("/vehicles/{id}")
  public Optional<Vehicle> getVehicleById(@PathVariable Long id){
    return vehicleService.getVehicleById(id);
  }

}
