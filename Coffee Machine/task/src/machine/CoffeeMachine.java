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

        coffeeMachine.printMachineState();

        String action = chooseAction();

        if ("buy".equals(action)) {
            chooseCoffee(coffeeMachine);
        } else if ("fill".equals(action)) {
            fillMachine(coffeeMachine);
        } else if ("take".equals(action)) {
            coffeeMachine.money = 0;
        }

        coffeeMachine.printMachineState();
    }

    private static String chooseAction() {
        System.out.println("\nWrite action (buy, fill, take):");
        return scanner.next();
    }

    private static void chooseCoffee(CoffeeMachine coffeeMachine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int option = scanner.nextInt();

        Coffee coffee = null;

        switch (option) {
            case 1:
                coffee = new Espresso();
                break;
            case 2:
                coffee = new Latte();
                break;
            case 3:
                coffee = new Cappuccino();
                break;
        }

        coffeeMachine.availableBeans -= coffee.getBeans();
        coffeeMachine.availableMilk -= coffee.getMilk();
        coffeeMachine.availableWater -= coffee.getWater();
        coffeeMachine.money += coffee.getPrice();
        coffeeMachine.availableCups -= 1;

        System.out.println();

    }

    private static void fillMachine(CoffeeMachine coffeeMachine) {
        System.out.println("Write how many ml of water you want to add: ");
        coffeeMachine.availableWater += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add: ");
        coffeeMachine.availableMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeMachine.availableBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        coffeeMachine.availableCups += scanner.nextInt();
    }

    private void printMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(availableWater + " ml of water");
        System.out.println(availableMilk + " ml of milk");
        System.out.println(availableBeans + " g of coffee beans");
        System.out.println(availableCups + " disposable cups");
        System.out.printf("$%d of money\n", money);

    }

    /*private static int countMaxAvailableCoffees(int water, int milk, int beans) {
        Integer[] maxCoffeeByIngredient = new Integer[3];

        maxCoffeeByIngredient[0] = water / WATER_FOR_ONE_COFFEE;
        maxCoffeeByIngredient[1] = milk / MILK_FOR_ONE_COFFEE;
        maxCoffeeByIngredient[2] = beans / BEANS_FOR_ONE_COFFEE;

        return Collections.min(List.of(maxCoffeeByIngredient));
    }*/
}
