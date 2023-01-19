package edu.midlands.training.repositories;

import edu.midlands.training.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findVehicleByType(String type);


    List<Vehicle> findVehicleByModel(String model);

    List<Vehicle> findVehicleByYear(Integer year);

    List<Vehicle> findVehicleBymake(String make);

    List<Vehicle> findVehicleByMakeAndModel(String make,String model);

    List<Vehicle> findVehicleByMakeAndYear(String make,Integer year);

    List<Vehicle> findVehicleByMakeAndType(String make,String type);

    List<Vehicle> findVehicleByTypeAndModel(String type,String model);

    List<Vehicle> findVehicleByTypeAndYear(String type,Integer year);


}
