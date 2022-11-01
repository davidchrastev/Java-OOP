package EncapsulationExercises.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split(" ");
        String pizzaName = pizzaData[1];
        int countOfToppings = Integer.parseInt(pizzaData[2]);

        String[] doughData = scanner.nextLine().split(" ");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);

        try {
            Pizza pizza = new Pizza(pizzaName,countOfToppings);
            Dough dough = new Dough(flourType,bakingTechnique,doughWeight);
            pizza.setDough(dough);

            String toppingData = scanner.nextLine();

            while (!toppingData.equals("END")) {
                String[] toppingInfo = toppingData.split(" ");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);

                Topping topping = new Topping(toppingType,toppingWeight);
                pizza.addTopping(topping);

                toppingData = scanner.nextLine();
            }
            System.out.println(pizza);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
