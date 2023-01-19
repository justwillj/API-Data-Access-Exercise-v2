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
  public List<Vehicle> getVehicles(String type, String make,String model,Integer year) {
    List<Vehicle> queryVehicle = new ArrayList<>();
    if (type == null && make == null && model == null && year == null) {
      return vehicleRepository.findAll();
    }
    if (type != null && make != null && model != null && year != null) {
      return vehicleRepository.findAll();
    }
    if(type!=null){
      if( make!=null && model==null && year==null ){
        List<Vehicle> result = new ArrayList<>();
        result.addAll(vehicleRepository.findVehicleByType(type));
        result.addAll(vehicleRepository.findVehicleBymake(make));
        return result;
      }
      if(make==null && model!=null &&year==null){
        List<Vehicle> result = new ArrayList<>();
        result.addAll(vehicleRepository.findVehicleByType(type));
        result.addAll(vehicleRepository.findVehicleByModel(model));
        return result;
      }
      if(year!=null &&make==null &&model==null){
        return vehicleRepository.findVehicleByMakeAndType(make,type);
      }
      else{
        return vehicleRepository.findVehicleByType(type);

      }

    }
    else if(make!=null){
      if(type!=null && model==null &&year==null){
        return vehicleRepository.findVehicleByMakeAndType(make,type);

      }
      if(model!=null && type==null && year==null){
        return vehicleRepository.findVehicleByMakeAndModel(make,model);
      }
      if(year!=null && type==null &&model==null){
        return vehicleRepository.findVehicleByMakeAndYear(make,year);

      }
      else{
        return vehicleRepository.findVehicleBymake(make);
      }

    } else if(model!=null) {
      if(type!=null && make==null &&year==null){
        List<Vehicle> result = new ArrayList<>();
        result.addAll(vehicleRepository.findVehicleByType(type));
        result.addAll(vehicleRepository.findVehicleByModel(model));
        return result;

      }
      if(make!=null && type==null && year==null){

        return vehicleRepository.findVehicleByMakeAndModel(make,model);
      }
      if(year!=null && type==null &&make==null){
        List<Vehicle> result = new ArrayList<>();
        result.addAll(vehicleRepository.findVehicleByModel(model));
        result.addAll(vehicleRepository.findVehicleByYear(year));
        return result;

      }
      else{
        return vehicleRepository.findVehicleByModel(model);
      }



    }
    else if(year!=null) {
      if (type != null && make == null && model == null) {
        List<Vehicle> result = new ArrayList<>();
        result.addAll(vehicleRepository.findVehicleByType(type));
        result.addAll(vehicleRepository.findVehicleByYear(year));
        return result;

      }
      if (make != null && type == null && model == null) {
        return vehicleRepository.findVehicleByMakeAndYear(make,year);

      }
      if (model != null && type == null && make == null) {
        List<Vehicle> result = new ArrayList<>();
        result.addAll(vehicleRepository.findVehicleByModel(model));
        result.addAll(vehicleRepository.findVehicleByYear(year));
        return result;

      } else {
        return vehicleRepository.findVehicleByYear(year);
      }
    }






    throw new VehicleNotFound();

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

  @Override
  public List<Vehicle> findVehicleByMakeAndModel(String make, String model) {
    List<Vehicle> vehicleTypes = new ArrayList<>();
    if (make!= null && model!=null) {

      for (Vehicle v : vehicleRepository.findAll()) {
        if (Objects.equals(v.getModel(), model)) {
          if (Objects.equals(v.getMake(), make)) {

            vehicleTypes.add(v);
            return vehicleTypes;
          }
        }
      }


    }
    return null;}

  @Override
  public List<Vehicle> findVehicleByMakeAndYear(String make, Integer year) {
    List<Vehicle> vehicleTypes = new ArrayList<>();
    if (make!= null && year!=null) {

      for (Vehicle v : vehicleRepository.findAll()) {
        if (Objects.equals(v.getYear(),year)) {
          if (Objects.equals(v.getMake(), make)) {

            vehicleTypes.add(v);
            return vehicleTypes;
          }
        }
      }


    }
    return null;}


  @Override
  public List<Vehicle> findVehicleByMakeAndType(String make, String type) {
    List<Vehicle> vehicleTypes = new ArrayList<>();
    if (make!= null && type!=null) {

      for (Vehicle v : vehicleRepository.findAll()) {
        if (Objects.equals(v.getType(),type) ){
          if (Objects.equals(v.getMake(), make)) {

            vehicleTypes.add(v);
            return vehicleTypes;
          }
        }
      }


    }
    return null;
  }

}
