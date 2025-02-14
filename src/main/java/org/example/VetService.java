package org.example;

import org.example.animals.Animal;

public class VetService {
    boolean checkAnimal(Animal animal) {
        return animal.getHealth() > 4;
    }
}
