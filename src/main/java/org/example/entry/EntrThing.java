package org.example.entry;

import org.example.things.Thing;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("entrThing")
public class EntrThing {
    public boolean addThing(List<Thing> things, Thing thing) {
        things.add(thing);
        return true;
    }
}
