package edu.midlands.training.services;

import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.repositories.VehicleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleServiceImpl implements VehicleService{

  @Autowired
  private VehicleRepository vehicleRepository;
  @Override
  public List<Vehicle> getVehicles() {
    return vehicleRepository.findAll();
  }
}
