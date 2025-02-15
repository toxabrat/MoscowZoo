package org.example.things;

import lombok.Getter;
import org.example.properties.zoo.objects.IInventory;

public class Thing implements IInventory {
    private int number;
    @Getter private String name;

    public Thing(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public int Number() {
        return number;
    }
}
