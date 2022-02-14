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
        super(250, 0, 16, 4);
    }
}

class Latte extends Coffee {
    public Latte() {
        super(350, 75, 20, 7);
    }
}

class Cappuccino extends Coffee {
    public Cappuccino() {
        super(200, 100, 12, 6);
    }
}
