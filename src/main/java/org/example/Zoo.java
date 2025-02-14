package org.example;

import lombok.Getter;
import org.example.animals.Animal;
import org.example.things.Thing;

import java.util.ArrayList;

public class Zoo {
    @Getter private ArrayList<Animal> animals;
    @Getter private ArrayList<Thing> things;
    private VetService vetService;
    private EntrService entrService;

    public Zoo(VetService vetService, EntrService entrService) {
        this.vetService = vetService;
        this.entrService = entrService;
    }


}
