package edu.midlands.training.controllers;

import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.services.VehicleService;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

  @Autowired
  private VehicleService vehicleService;

/**  CRUD Function for Vehicles to Get  All Vehicles from vehicleRepository
 * When there is any parameter then it returns the object records  with that parameter
 * When given none object returns all the records*/
  @GetMapping(value = "/vehicles")
  public List<Vehicle>getVehicles(@RequestParam (required = false )String type, @RequestParam (required = false) String make,
                                  @RequestParam(required=false) String model,@RequestParam (required=false) Integer year){
    return vehicleService.getVehicles(type,make,model,year);
  }


/**  CRUD Functions for Vehicles to get the vehicle with matching Id.*/
  @GetMapping("/vehicles/{id}")
  public Vehicle getVehicleById(@PathVariable Long id){
    return vehicleService.getVehicleById(id);
  }

  /** CRUD Function for Vehicles to delete the vehicle with matching Id
   * */
  @DeleteMapping("/vehicles/{id}")
  public void deleteVehicleById(@PathVariable Long id){
    vehicleService.deleteVehicleById(id);
  }

  /** CRUD function for Vehicles to update a Vehicle when given an Id*/
  @PutMapping("/vehicles/{id}")
  public Vehicle updateVehicleById(@PathVariable Long id, @RequestBody Vehicle newVehicle){
    return vehicleService.updateVehicleById(id,newVehicle);
  }

  /** CRUD fucntion for Vehicles to add new vehicle */
  @PostMapping("/vehicles")
  public Vehicle addVehicle(@RequestBody Vehicle newVehicle){
    return vehicleService.addVehicle(newVehicle);
  }

  //GET MAPPING FOR THE QUERY STATEMENTS

}
