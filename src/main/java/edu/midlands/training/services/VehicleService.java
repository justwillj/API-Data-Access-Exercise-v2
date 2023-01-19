package edu.midlands.training.services;

import edu.midlands.training.entities.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleService {
  List<Vehicle>getVehicles(String type, String make);

  Optional<Vehicle> getVehicleById(Long id);

  void deleteVehicleById(Long id);

  Vehicle updateVehicleById(Long id, Vehicle newVehicle);
  Vehicle addVehicle(Vehicle newVehicle);

  Vehicle getByType(String type);
}
