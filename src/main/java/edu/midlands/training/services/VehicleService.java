package edu.midlands.training.services;

import edu.midlands.training.entities.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleService {
  List<Vehicle>getVehicles();

  Optional<Vehicle> getVehicleById(Long id);

  void deleteVehicleById(Long id);

  Vehicle updateVehicleById(Long id, Vehicle newVehicle);
}
