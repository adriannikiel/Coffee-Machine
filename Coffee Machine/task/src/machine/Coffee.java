package machine;

public abstract class Coffee {
    private final int water;
    private final int milk;
    private final int beans;
    private final int price;

    public Coffee(int water, int milk, int beans, int price) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getPrice() {
        return price;
    }
}

class Espresso extends Coffee {

    public Espresso() {
        this(250, 0, 16, 4);
    }

    private Espresso(int water, int milk, int beans, int price) {
        super(water, milk, beans, price);
    }
}

class Latte extends Coffee {

    public Latte() {
        this(350, 75, 20, 7);
    }

    private Latte(int water, int milk, int beans, int price) {
        super(water, milk, beans, price);
    }
}

class Cappuccino extends Coffee {

    public Cappuccino() {
        this(200, 100, 12, 6);
    }

    private Cappuccino(int water, int milk, int beans, int price) {
        super(water, milk, beans, price);
    }
}
