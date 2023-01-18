package edu.midlands.training.data;

import edu.midlands.training.entities.Review;
import edu.midlands.training.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {



    }

    @Autowired
    private Review review;

    @Autowired
    private Vehicle vehicle;


}
