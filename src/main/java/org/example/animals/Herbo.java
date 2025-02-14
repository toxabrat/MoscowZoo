package org.example.animals;

public class Herbo extends Animal {

    public boolean healthy() {
        return kindness > 5;
    }

    public Herbo(String name, int health, int food, int kindness) {
        super(name, health, food);
        this.kindness = kindness;
    }

    private int kindness;
}
