package org.example;

import lombok.Getter;
import org.example.animals.Animal;
import org.example.entry.EntrAnimal;
import org.example.entry.EntrThing;
import org.example.things.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Zoo {
    @Getter private List<Animal> animals = new ArrayList<>();
    @Getter private List<Thing> things = new ArrayList<>();
    private VetService vetService;
    private EntrAnimal entrAnimal;
    private EntrThing entrThing;

    @Autowired
    public Zoo(@Qualifier("vetService") VetService vetService,
               @Qualifier("entrAnimal") EntrAnimal entrAnimal,
               @Qualifier("entrThing") EntrThing entrThing) {
        this.vetService = vetService;
        this.entrAnimal = entrAnimal;
        this.entrThing = entrThing;
    }

    public boolean pushAnimal(Animal animal) {
        return entrAnimal.addAnimal(animals, animal, vetService);
    }

    public boolean pushThing(Thing thing) {
        return entrThing.addThing(things, thing);
    }
}
