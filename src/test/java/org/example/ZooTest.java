package org.example;

import org.example.animals.Animal;
import org.example.animals.Predator;
import org.example.animals.exist.Monkey;
import org.example.animals.exist.Rabbit;
import org.example.animals.exist.Tiger;
import org.example.animals.exist.Wolf;
import org.example.things.Computer;
import org.example.things.Table;
import org.example.things.Thing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ZooTest {

    @Autowired
    private Zoo zoo;

    @Test
    void shouldCorrectlyAddZooObjects() {
        List<Animal> animals;
        List<Thing> things;

        zoo.pushAnimal(new Predator("хахах", 10, 10));
        zoo.pushThing(new Thing(4, "утюг"));
        animals = zoo.getAnimals();
        things = zoo.getThings();

        assertEquals("хахах".hashCode(), animals.getFirst().getName().hashCode());
        assertEquals(4, things.getFirst().Number());
    }

    @Test
    void shouldAddExistingClassesCorrectly() {
        List<Animal> animals;
        List<Thing> things;

        zoo.pushAnimal(new Monkey(10));
        zoo.pushAnimal(new Rabbit(10));
        zoo.pushAnimal(new Tiger(10));
        zoo.pushAnimal(new Wolf(10));
        zoo.pushThing(new Table(10));
        zoo.pushThing(new Computer(10));
        animals = zoo.getAnimals();
        things = zoo.getThings();

        assertEquals("обезьяна".hashCode(), animals.getFirst().getName().hashCode());
        assertEquals("кролик".hashCode(), animals.get(1).getName().hashCode());
        assertEquals("тигр".hashCode(), animals.get(2).getName().hashCode());
        assertEquals("волк".hashCode(), animals.get(3).getName().hashCode());
        assertEquals("стол".hashCode(), things.getFirst().getName().hashCode());
        assertEquals("компьютер".hashCode(), things.get(1).getName().hashCode());
    }
}
