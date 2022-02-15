package machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMaker {

    private State state = State.STANDBY;

    private int availableWater = 400;
    private int availableMilk = 540;
    private int availableBeans = 120;
    private int availableCups = 9;
    private int money = 550;

    public CoffeeMaker() {
        showActions();
    }

    public void process(String input) {

        if (state == State.STANDBY) {
            processStandby(input);
            return;
        }

        if (state == State.PREPARING_COFFEE) {
            chooseCoffee(input);
            showActions();
            state = State.STANDBY;
            return;
        }

        if (state == State.FILLING_WATER) {
            fillWater(input);
            state = State.FILLING_MILK;
            return;
        }

        if (state == State.FILLING_MILK) {
            fillMilk(input);
            state = State.FILLING_BEANS;
            return;
        }

        if (state == State.FILLING_BEANS) {
            fillBeans(input);
            state = State.FILLING_CUPS;
            return;
        }

        if (state == State.FILLING_CUPS) {
            fillCups(input);
            showActions();
            state = State.STANDBY;
            return;
        }
    }

    private void processStandby(String input) {
        if ("buy".equals(input)) {
            showCoffees();
            state = State.PREPARING_COFFEE;
        } else if ("fill".equals(input)) {
            startFillingWater();
            state = State.FILLING_WATER;
        } else if ("take".equals(input)) {
            takeMoney();
            showActions();
        } else if ("remaining".equals(input)) {
            printMachineState();
            showActions();
        } else if ("exit".equals(input)) {
            System.exit(0);
        }
    }

    private void showActions() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    private void showCoffees() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
    }

    private void takeMoney() {
        System.out.printf("\nI gave you $%d\n\n", money);
        money = 0;
    }

    private void chooseCoffee(String option) {

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

        List<String> missingResources = checkResources(coffee);

        if (missingResources.isEmpty()) {
            System.out.println("I have enough resources, making you a coffee!\n");

            availableBeans -= coffee.getBeans();
            availableMilk -= coffee.getMilk();
            availableWater -= coffee.getWater();
            money += coffee.getPrice();
            availableCups -= 1;
        } else {
            System.out.print("Sorry, not enough");

            for (int i = 0; i < missingResources.size() - 1; i++) {
                System.out.print(" " + missingResources.get(i) + ",");
            }

            System.out.println(" " + missingResources.get(missingResources.size() - 1) + "!\n");
        }

    }

    private List<String> checkResources(Coffee coffee) {
        List<String> missingResources = new ArrayList<>();

        if (availableCups - 1 < 0) {
            missingResources.add("cups");
        }

        if (availableBeans - coffee.getBeans() < 0) {
            missingResources.add("beans");
        }

        if (availableMilk - coffee.getMilk() < 0) {
            missingResources.add("milk");
        }

        if (availableWater - coffee.getWater() < 0) {
            missingResources.add("water");
        }

        return missingResources;
    }

    private void startFillingWater() {
        System.out.println("\nWrite how many ml of water you want to add: ");
    }

    private void fillWater(String input) {
        int quantity = Integer.parseInt(input);
        availableWater += quantity;
        System.out.println("Write how many ml of milk you want to add: ");
    }

    private void fillMilk(String input) {
        int quantity = Integer.parseInt(input);
        availableMilk += quantity;
        System.out.println("Write how many grams of coffee beans you want to add: ");
    }

    private void fillBeans(String input) {
        int quantity = Integer.parseInt(input);
        availableBeans += quantity;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
    }

    private void fillCups(String input) {
        int quantity = Integer.parseInt(input);
        availableCups += quantity;
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

}
