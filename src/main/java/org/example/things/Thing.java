package org.example.things;

import org.example.properties.zoo.objects.IInventory;

public class Thing implements IInventory {
    private int number;

    public Thing(int number) {
        this.number = number;
    }

    @Override
    public int Number() {
        return number;
    }
}
