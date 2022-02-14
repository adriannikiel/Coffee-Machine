package machine;

import java.util.*;

public class CoffeeMachine {

    //public static final int WATER_FOR_ONE_COFFEE = 200;
    //public static final int MILK_FOR_ONE_COFFEE = 50;
    //public static final int BEANS_FOR_ONE_COFFEE = 15;

    private int availableWater = 400;
    private int availableMilk = 540;
    private int availableBeans = 120;
    private int availableCups = 9;
    private int money = 550;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            String action = chooseAction();

            if ("buy".equals(action)) {
                chooseCoffee(coffeeMachine);
            } else if ("fill".equals(action)) {
                fillMachine(coffeeMachine);
            } else if ("take".equals(action)) {
                System.out.printf("\nI gave you $%d\n\n", coffeeMachine.money);
                coffeeMachine.money = 0;
            } else if ("remaining".equals(action)) {
                coffeeMachine.printMachineState();
            } else if ("exit".equals(action)) {
                return;
            }
        }
    }

    private static String chooseAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return scanner.next();
    }

    private static void chooseCoffee(CoffeeMachine coffeeMachine) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String option = scanner.next();

        Coffee coffee = null;

        switch (option) {
            case "1":
                coffee = new Espresso();
                break;
            case "2":
                coffee = new Latte();
                break;
            case "3":
                coffee = new Cappuccino();
                break;
            case "back":
                return;
        }

        List<String> missingResources = checkResources(coffee, coffeeMachine);

        if (missingResources.isEmpty()) {
            System.out.println("I have enough resources, making you a coffee!\n");

            coffeeMachine.availableBeans -= coffee.getBeans();
            coffeeMachine.availableMilk -= coffee.getMilk();
            coffeeMachine.availableWater -= coffee.getWater();
            coffeeMachine.money += coffee.getPrice();
            coffeeMachine.availableCups -= 1;
        } else {
            System.out.print("Sorry, not enough");

            for (int i = 0; i < missingResources.size() - 1; i++) {
                System.out.print(" " + missingResources.get(i) + ",");
            }

            System.out.println(" " + missingResources.get(missingResources.size() - 1) + "!\n");
        }

    }

    private static List<String> checkResources(Coffee coffee, CoffeeMachine coffeeMachine) {
        List<String> missingResources = new ArrayList<>();

        if (coffeeMachine.availableCups - 1 < 0) {
            missingResources.add("cups");
        }

        if (coffeeMachine.availableBeans - coffee.getBeans() < 0) {
            missingResources.add("beans");
        }

        if (coffeeMachine.availableMilk - coffee.getMilk() < 0) {
            missingResources.add("milk");
        }

        if (coffeeMachine.availableWater - coffee.getWater() < 0) {
            missingResources.add("water");
        }

        return missingResources;
    }

    private static void fillMachine(CoffeeMachine coffeeMachine) {
        System.out.println("\nWrite how many ml of water you want to add: ");
        coffeeMachine.availableWater += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add: ");
        coffeeMachine.availableMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeMachine.availableBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        coffeeMachine.availableCups += scanner.nextInt();

        System.out.println();
    }

    private void printMachineState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(availableWater + " ml of water");
        System.out.println(availableMilk + " ml of milk");
        System.out.println(availableBeans + " g of coffee beans");
        System.out.println(availableCups + " disposable cups");
        System.out.printf("$%d of money\n\n", money);
    }

    /*private static int countMaxAvailableCoffees(int water, int milk, int beans) {
        Integer[] maxCoffeeByIngredient = new Integer[3];

        maxCoffeeByIngredient[0] = water / WATER_FOR_ONE_COFFEE;
        maxCoffeeByIngredient[1] = milk / MILK_FOR_ONE_COFFEE;
        maxCoffeeByIngredient[2] = beans / BEANS_FOR_ONE_COFFEE;

        return Collections.min(List.of(maxCoffeeByIngredient));
    }*/
}
