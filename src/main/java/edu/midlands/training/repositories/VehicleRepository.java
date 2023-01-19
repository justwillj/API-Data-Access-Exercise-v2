package edu.midlands.training.repositories;

import edu.midlands.training.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findVehicleByType(String type);

    List<Vehicle> findVehicleBymake(String make);

    List<Vehicle> findVehicleByModel(String model);

    List<Vehicle> findVehicleByYear(Integer year);


}
