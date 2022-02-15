package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        while (true) {
            String input = scanner.next();
            coffeeMaker.process(input);
        }
    }
}
