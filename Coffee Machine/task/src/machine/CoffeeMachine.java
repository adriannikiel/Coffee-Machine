package machine;

import java.util.*;

public class CoffeeMachine {

    public static final int WATER_FOR_ONE_COFFEE = 200;
    public static final int MILK_FOR_ONE_COFFEE = 50;
    public static final int BEANS_FOR_ONE_COFFEE = 15;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int coffees = scanner.nextInt();

        int maxCoffee = countMaxAvailableCoffees(water, milk, beans);

        if (coffees == maxCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (coffees > maxCoffee) {
            System.out.printf("No, I can make only %d cup(s) of coffee", maxCoffee);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", maxCoffee - coffees);
        }

    }

    private static int countMaxAvailableCoffees(int water, int milk, int beans) {
        Integer[] maxCoffeeByIngredient = new Integer[3];

        maxCoffeeByIngredient[0] = water / WATER_FOR_ONE_COFFEE;
        maxCoffeeByIngredient[1] = milk / MILK_FOR_ONE_COFFEE;
        maxCoffeeByIngredient[2] = beans / BEANS_FOR_ONE_COFFEE;

        return Collections.min(List.of(maxCoffeeByIngredient));
    }
}
