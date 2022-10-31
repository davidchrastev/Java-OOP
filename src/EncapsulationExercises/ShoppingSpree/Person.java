package EncapsulationExercises.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s",name,product.getName()));
        }
        products.add(product);
        money -= product.getCost();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " - ");
        List<String> productsName = new ArrayList<>();
        for (Product product : products) {
            productsName.add(product.getName());
        }
        if (productsName.isEmpty()) {
            stringBuilder.append("Nothing bought");
        } else {
            stringBuilder.append(String.join(", ",productsName));
        }

        return stringBuilder.toString();

    }
}
