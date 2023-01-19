package edu.midlands.training.services;

import edu.midlands.training.entities.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleService {
  List<Vehicle>getVehicles(String type, String make,String model,Integer year);

  Vehicle getVehicleById(Long id);

  void deleteVehicleById(Long id);

  Vehicle updateVehicleById(Long id, Vehicle newVehicle);
  Vehicle addVehicle(Vehicle newVehicle);

  List<Vehicle> findVehicleByType(String type);


  List<Vehicle> findVehicleByModel(String model);

  List<Vehicle> findVehicleByYear(Integer year);

  List<Vehicle> findVehicleBymake(String make);

  List<Vehicle> findVehicleByMakeAndModel(String make,String model);

  List<Vehicle> findVehicleByMakeAndYear(String make,Integer year);

  List<Vehicle> findVehicleByMakeAndType(String make,String type);



}
