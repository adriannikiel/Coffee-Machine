package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        final int WATER_FOR_ONE_COFFEE = 200;
        final int MILK_FOR_ONE_COFFEE = 50;
        final int BEANS_FOR_ONE_COFFEE = 15;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int coffees = scanner.nextInt();

        System.out.printf("For %d cups of coffee you will need:\n", coffees);
        System.out.println(coffees * WATER_FOR_ONE_COFFEE + " ml of water");
        System.out.println(coffees * MILK_FOR_ONE_COFFEE + " ml of milk");
        System.out.println(coffees * BEANS_FOR_ONE_COFFEE + " g of coffee beans");

       /* System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");*/

    }
}
