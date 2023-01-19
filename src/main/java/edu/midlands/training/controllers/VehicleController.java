package edu.midlands.training.controllers;

import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.services.VehicleService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

  @Autowired
  private VehicleService vehicleService;

  //TEST
  @GetMapping(value = "/vehicles")
  public List<Vehicle>getVehicles(@RequestParam (required = false )String type, @RequestParam (required = false) String make,
                                  @RequestParam(required=false) String model,@RequestParam (required=false) Integer year){
    return vehicleService.getVehicles(type,make,model,year);
  }

  @GetMapping("/vehicles/{id}")
  public Vehicle getVehicleById(@PathVariable Long id){
    return vehicleService.getVehicleById(id);
  }

  @DeleteMapping("/vehicles/{id}")
  public void deleteVehicleById(@PathVariable Long id){
    vehicleService.deleteVehicleById(id);
  }

  @PutMapping("/vehicles/{id}")
  public Vehicle updateVehicleById(@PathVariable Long id, @RequestBody Vehicle newVehicle){
    return vehicleService.updateVehicleById(id,newVehicle);
  }

  @PostMapping("/vehicles")
  public Vehicle addVehicle(@RequestBody Vehicle newVehicle){
    return vehicleService.addVehicle(newVehicle);
  }

  //GET MAPPING FOR THE QUERY STATEMENTS

}
