package EncapsulationExercises.ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();
        String[] dataPeople = scanner.nextLine().split(";");
        String[] productsData = scanner.nextLine().split(";");


        extractPeople(people, dataPeople);
        extractProducts(products,productsData);

        String toBuy = scanner.nextLine();

        while (!toBuy.equals("END")) {
            String[] data = toBuy.split(" ");
            String personName = data[0];
            String productName = data[1];

            buyProduct(people, products, personName, productName);

            toBuy = scanner.nextLine();
        }
        for (Person person : people.values()) {
            System.out.println(person);
        }
    }

    private static void buyProduct(Map<String, Person> people, Map<String, Product> products, String personName, String productName) {
        try {
            people.get(personName).buyProduct(products.get(productName));
            System.out.printf("%s bought %s%n",personName,productName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void extractProducts(Map<String, Product> products, String[] productsData) {
        for (String productData : productsData) {
            String[] productParts = productData.split("=");
            String name = productParts[0];
            double cost = Double.parseDouble(productParts[1]);

            try {
                Product product = new Product(name,cost);
                products.put(name,product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    private static void extractPeople(Map<String, Person> people, String[] data) {
        for (String personData : data) {
            String[] personParts = personData.split("=");
            String name = personParts[0];
            double money = Double.parseDouble(personParts[1]);

            try {
                Person person = new Person(name,money);
                people.put(name,person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }
}
