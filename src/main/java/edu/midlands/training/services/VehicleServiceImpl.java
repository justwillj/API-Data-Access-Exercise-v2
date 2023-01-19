package edu.midlands.training.services;

import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.repositories.VehicleRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class VehicleServiceImpl implements VehicleService{

  @Autowired
  private VehicleRepository vehicleRepository;
  @Override
  public List<Vehicle> getVehicles() {
    return vehicleRepository.findAll();
  }

  @Override
  public Vehicle getVehicleById(Long id) {
    for (Vehicle v: vehicleRepository.findAll()) {
      if(v.getId() == id){
        return v;
      }
    }
    return null;
  }

  @Override
  public void deleteVehicleById(Long id) {
    vehicleRepository.deleteById(id);
  }

  @Override
  public Vehicle updateVehicleById(Long id, Vehicle newVehicle) {
    return vehicleRepository.save(newVehicle);
  }

  @Override
  public Vehicle addVehicle(Vehicle newVehicle) {
    return vehicleRepository.save(newVehicle);
  }


}
