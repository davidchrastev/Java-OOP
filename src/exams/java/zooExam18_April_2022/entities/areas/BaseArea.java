package exams.java.zooExam18_April_2022.entities.areas;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private List<Food> foods;
    private List<Animal> animals;


    protected BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(animals);
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(foods);
    }

    @Override
    public int sumCalories() {
        int sum = 0;
        for (Food food : foods) {
            sum += food.getCalories();
        }
        return sum;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder()
                .append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Animal: ");

        if (this.animals.isEmpty()) {
            output.append("none");
        } else {

            output.append(this.animals.stream().map(Animal::getName).collect(Collectors.joining(" ")));
        }

        output
                .append(System.lineSeparator())
                .append("Foods: ")
                .append(this.foods.size())
                .append(System.lineSeparator())
                .append("Calories: ")
                .append(this.sumCalories());

        return output.toString().trim();
    }
}
