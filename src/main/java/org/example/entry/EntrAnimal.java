package org.example.entry;

import org.example.VetService;
import org.example.animals.Animal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("entrAnimal")
public class EntrAnimal {
    public boolean addAnimal(List<Animal> animals, Animal animal, VetService vetService) {
        if(vetService.checkAnimal(animal)) {
            animals.add(animal);
            return true;
        } else {
            return false;
        }
    }
}
