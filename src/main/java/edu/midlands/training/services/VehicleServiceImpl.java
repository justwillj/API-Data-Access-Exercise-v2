package edu.midlands.training.services;

import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.repositories.VehicleRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService{

  @Autowired
  private VehicleRepository vehicleRepository;
  @Override
  public List<Vehicle> getVehicles() {
    return vehicleRepository.findAll();
  }

  @Override
  public Optional<Vehicle> getVehicleById(Long id) {
    return vehicleRepository.findById(id);
  }
}
