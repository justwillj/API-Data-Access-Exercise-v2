package edu.midlands.training.services;

import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.exceptions.VehicleNotFound;
import edu.midlands.training.repositories.VehicleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleServiceImpl implements VehicleService{

  @Autowired
  private VehicleRepository vehicleRepository;

  /**getting all Vehicles
   * Takes type,make,model,year of the vehicles
   * If there are no parameters given then it returns all vehicles
   * If there is any parameter given then it returns the vehicles List that has that specific argument
   **/
  @Override
  public List<Vehicle> getVehicles(String type, String make,String model,Integer year) {
    List<Vehicle> queryVehicle =new ArrayList<>();
    if (type == null && make == null &&model==null &&year==null){
      return vehicleRepository.findAll();
    }
    if(type!=null && make!=null && model!=null && year!=null){
      return vehicleRepository.findAll();
    }


    if (type != null && make != null){
    for (Vehicle v :vehicleRepository.findAll()) {
        if (Objects.equals(v.getType(), type)) {
          if (Objects.equals(v.getMake(),make)) {
            queryVehicle.add(v);
          }
        }
      }
    } else if (type != null){
      return vehicleRepository.findVehicleByType(type);
        }

     else if (make != null) {
      return vehicleRepository.findVehicleBymake(make);
    }
     else if(year!=null){
       return vehicleRepository.findVehicleByYear(year);
    }
     else if(model!=null){
       return vehicleRepository.findVehicleByModel(model);
    }

    return queryVehicle;
  }


  /** Gets the vehicle by its id\
   * @Param id id of the vehicle
   * @returns the vehicle with matching id
   * if there are no vehicles with matching ids then it throws an exception*/
  @Override
  public Vehicle getVehicleById(Long id) {
    for (Vehicle v: vehicleRepository.findAll()) {
      if(v.getId() == id){
        return v;
      }
    }
    return null;
  }

  /** Deletes the vehicle Based on id
   * @Param id id of the vehicle
   * If there is no vehicle with matching id it gives an exception*/
  @Override
  public void deleteVehicleById(Long id) {
    vehicleRepository.deleteById(id);
  }


  /** Updates the vehicle based on the matching id
   * @Param id of the vehicle
   * @Param new vehicle to be updated
   * @returns the updated newvehicle*/
  @Override
  public Vehicle updateVehicleById(Long id, Vehicle newVehicle) {
    return vehicleRepository.save(newVehicle);
  }


  /** Adds the vehicle
   * @Param new vehicle to be updated
   * @returns the newvehicle*/
  @Override
  public Vehicle addVehicle(Vehicle newVehicle) {
    return vehicleRepository.save(newVehicle);
  }


  /**Finds the vehicle given the type of the vehicle
   * @Param type of the vehicle
   * @returns List of vehicles with that type
   * If there are no vehicles with matching type then throws and exception*/
  @Override
  public List<Vehicle> findVehicleByType (String type){
    List<Vehicle> vehicleTypes = new ArrayList<>();
    if (type != null) {

      for (Vehicle v : vehicleRepository.findAll()) {
        if (Objects.equals(v.getType(), type)) {
          vehicleTypes.add(v);
          return vehicleTypes;
        }
      }


    }
    throw new VehicleNotFound();
  }

  /**Finds the vehicle given the make of the vehicle
   * @Param make of the vehicle
   * @returns List of vehicles with that make
   * If there are no vehicles with matching make then throws and exception*/
  @Override
  public List<Vehicle> findVehicleBymake (String make){
    List<Vehicle> vehicleTypes = new ArrayList<>();
    if (make == null) {


      for (Vehicle v : vehicleRepository.findAll()) {
        if (Objects.equals(v.getType(), make)) {
          vehicleTypes.add(v);
          return vehicleTypes;
        }
      }

    }
    throw new VehicleNotFound();
  }


  /**Finds the vehicle given the model of the vehicle
   * @Param model of the vehicle
   * @returns List of vehicles with that model
   * If there are no vehicles with matching model then throws and exception*/
  @Override
  public List<Vehicle> findVehicleByModel(String model) {
    List<Vehicle> vehicleTypes = new ArrayList<>();
    for (Vehicle v : vehicleRepository.findAll()) {
      if (Objects.equals(v.getModel(), model)) {
        vehicleTypes.add(v);
        return vehicleTypes;
      }
    }
    return null;

  }

  /**Finds the vehicle given the year of the vehicle
   * @Param year of the vehicle
   * @returns List of vehicles with that year
   * If there are no vehicles with matching year then throws and exception*/
  @Override
  public List<Vehicle> findVehicleByYear(Integer year) {
    List<Vehicle> vehicleTypes = new ArrayList<>();
    for (Vehicle v : vehicleRepository.findAll()) {
      if (Objects.equals(v.getType(), year)) {
        vehicleTypes.add(v);
        return vehicleTypes;
      }
    }
    return null;
  }


}
