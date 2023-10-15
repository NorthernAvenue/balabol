package fruit;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    private double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

class Orange extends Fruit {
    public Orange(double weight) {
        super(weight);
    }
}

class Apple extends Fruit {
    public Apple(double weight) {
        super(weight);
    }
}

class GoldenApple extends Fruit {
    public GoldenApple(double weight) {
        super(weight);
    }
}

class FruitBox<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public void transferTo(FruitBox<T> otherBox) {
        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}


