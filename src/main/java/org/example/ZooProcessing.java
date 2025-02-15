package org.example;

import org.example.animals.Animal;
import org.example.animals.Herbo;
import org.example.animals.Predator;
import org.example.animals.exist.Monkey;
import org.example.animals.exist.Rabbit;
import org.example.animals.exist.Tiger;
import org.example.animals.exist.Wolf;
import org.example.drawable.objects.DrawAddAnimal;
import org.example.drawable.objects.DrawAnimals;
import org.example.drawable.objects.DrawKGNumber;
import org.example.drawable.objects.DrawStart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.IntStream;

public class ZooProcessing {
    public int start(PrintStream output) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        Zoo zoo = context.getBean(Zoo.class);
        DrawStart.mainMenu(output);
        int totalCommand = 0;

        while(true) {

            DrawStart.mainMenu(output);
            int a;
            String command = Input.getString();
            if (command == null || command.equalsIgnoreCase("выход")) {
                return totalCommand;
            }
            totalCommand += 1;
            try {
                a = Integer.parseInt(command);
            } catch (Exception _) {
                continue;
            }
            switch (a) {
                case 1 -> addAnimal(zoo, output);
                case 2 -> printZoo(zoo, output);
                case 3 -> printKg(zoo, output);
                case 4 -> printContactAnimal(zoo, output);
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void addAnimal(Zoo zoo, PrintStream output) {
        DrawAddAnimal.drawAddAnimal(output);
        String name = Input.getString();
        String health = Input.getString();
        if(name == null || health  == null) {
            DrawAddAnimal.drawNotBeenAdd(output);
            return;
        }

        try {
            Integer.parseInt(health);
        } catch (Exception _) {
            DrawAddAnimal.drawNotBeenAdd(output);
            return;
        }
        name = name.toLowerCase().replace(" ","");
        int healthInt = Integer.parseInt(health);

        if(healthInt < 0 || healthInt > 10) {
            DrawAddAnimal.drawNotBeenAdd(output);
            return;
        }

        boolean flag = true, flag1 = true;
        switch (name) {
            case "обезьяна" -> flag1 = zoo.pushAnimal(new Monkey(healthInt));
            case "кролик" -> flag1 = zoo.pushAnimal(new Rabbit(healthInt));
            case "тигр" -> flag1 = zoo.pushAnimal(new Tiger(healthInt));
            case "волк" -> flag1 = zoo.pushAnimal(new Wolf(healthInt));
            default -> flag = false;
        }
        if(flag && flag1) {
            DrawAddAnimal.drawBeenAdd(zoo.getAnimals().getLast().getName(), output);
            return;
        } else if(flag && !flag1) {
            DrawAddAnimal.drawHurt(output);
            return;
        }

        String kg = Input.getString();
        String type = Input.getString();
        if(kg == null || type == null) {
            DrawAddAnimal.drawNotBeenAdd(output);
            return;
        }

        try {
            Integer.parseInt(kg);
        } catch (Exception _) {
            DrawAddAnimal.drawNotBeenAdd(output);
            return;
        }

        int kgInt = Integer.parseInt(kg);
        type = type.toLowerCase().replace(" ","");
        String kindness;
        if(type.equals("хищник")) {
            flag = zoo.pushAnimal(new Predator(name, healthInt, kgInt));
            if(flag) {
                DrawAddAnimal.drawBeenAdd(zoo.getAnimals().getLast().getName(), output);
            } else {
                DrawAddAnimal.drawHurt(output);
            }

        } else if(type.equals("травоядное")) {
            kindness = Input.getString();
            if(kindness == null) {
                DrawAddAnimal.drawNotBeenAdd(output);
                return;
            }
            try {
                Integer.parseInt(kindness);
            } catch (Exception _) {
                DrawAddAnimal.drawNotBeenAdd(output);
                return;
            }
            int kindnessInt = Integer.parseInt(kindness);
            if(kindnessInt < 0 || kindnessInt > 10) {
                DrawAddAnimal.drawNotBeenAdd(output);
                return;
            }
            flag = zoo.pushAnimal(new Herbo(name, healthInt, kgInt, kindnessInt));
            if(flag) {
                DrawAddAnimal.drawBeenAdd(zoo.getAnimals().getLast().getName(), output);
            } else {
                DrawAddAnimal.drawHurt(output);
            }

        } else {
            DrawAddAnimal.drawNotBeenAdd(output);
        }
    }

    public void printZoo(Zoo zoo, PrintStream output) {
        List<String> animal = IntStream.range(0, zoo.getAnimals().size())
                .mapToObj(i -> i + 1 + " " + zoo.getAnimals().get(i).getName())
                .toList();
        DrawAnimals.drawAnimals(animal, output);
    }

    public void printKg(Zoo zoo, PrintStream output) {
        int a = zoo.getAnimals().stream()
                .map(Animal::getFood)
                .reduce(0, Integer::sum);
        DrawKGNumber.drawKGNumber(a, output);
    }

    public void printContactAnimal(Zoo zoo, PrintStream output) {
        List<Animal> contactAnimal = zoo.getAnimals().stream()
                .filter(animal1 -> animal1 instanceof Herbo)
                .filter(animal1 -> ((Herbo) animal1).healthy())
                .toList();
        List<String> animal = IntStream.range(0, contactAnimal.size())
                .mapToObj(i -> i + 1 + " " + contactAnimal.get(i).getName())
                .toList();
        DrawAnimals.drawAnimals(animal, output);
    }
}
