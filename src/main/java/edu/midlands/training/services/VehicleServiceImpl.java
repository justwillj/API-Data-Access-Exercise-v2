package edu.midlands.training.services;

import edu.midlands.training.entities.Vehicle;
import edu.midlands.training.exceptions.VehicleNotFound;
import edu.midlands.training.repositories.VehicleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class VehicleServiceImpl implements VehicleService{

  @Autowired
  private VehicleRepository vehicleRepository;
  @Override
  public List<Vehicle> getVehicles(String type, String make) {
    List<Vehicle> queryVehicle =new ArrayList<>();
    if (type == null && make == null){
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
      for (Vehicle v :vehicleRepository.findAll()) {
        if (Objects.equals(v.getType(), type)) {
          queryVehicle.add(v);
        }
      }
    } else if (make != null) {
      for (Vehicle v : vehicleRepository.findAll()) {
        if (Objects.equals(v.getMake(), make)) {
          queryVehicle.add(v);
        }
      }
    }
    return queryVehicle;
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
