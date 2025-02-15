package org.example;

import org.example.animals.Animal;
import org.springframework.stereotype.Component;

@Component("vetService")
public class VetService {
    public boolean checkAnimal(Animal animal) {
        return animal.getHealth() > 4;
    }
}
