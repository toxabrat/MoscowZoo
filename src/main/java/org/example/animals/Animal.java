package org.example.animals;

import lombok.Getter;
import org.example.properties.zoo.objects.IAlive;

@Getter
public abstract class Animal implements IAlive {

    public Animal(String name, int health, int food) {
        this.name = name;
        this.health = health;
        this.food = food;
    }

    @Override
    public int Food() {
        return food;
    }

    private String name;
    private int health;
    private int food;
}
