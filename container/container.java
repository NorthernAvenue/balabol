package container;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Box {
    private double weight;

    public Box(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

class Container implements Comparable<Container>, Iterable<Box> {
    public List<Box> boxes = new ArrayList<>();

    public void addBox(Box box) {
        boxes.add(box);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Box box : boxes) {
            totalWeight += box.getWeight();
        }
        return totalWeight;
    }

    @Override
    public int compareTo(Container other) {
        // Сравниваем контейнеры по весу
        return Double.compare(this.getTotalWeight(), other.getTotalWeight());
    }

    @Override
    public Iterator<Box> iterator() {
        return boxes.iterator();
    }
}

class ContainerCountComparator implements Comparator<Container> {
    @Override
    public int compare(Container container1, Container container2) {
        // Сравниваем контейнеры по количеству ящиков
        return Integer.compare(container1.boxes.size(), container2.boxes.size());
    }
}


