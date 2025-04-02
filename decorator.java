import java.util.*;

interface Coffee {
    public double getPrice();
}

class BasicCoffee implements Coffee {
    public double getPrice() {
        return 20.5;
    } 
}

abstract class CoffeeDecorator implements Coffee {
    Coffee coffee;
    
    public CoffeeDecorator(Coffee c) {
        this.coffee = c;
    }
}

class MilkCoffee extends CoffeeDecorator {
    public MilkCoffee(Coffee c) {
        super(c);
    }
    
    public double getPrice() {
        return 3 + this.coffee.getPrice();
    }
}

class HoneyCoffee extends CoffeeDecorator {
    public HoneyCoffee(Coffee c) {
        super(c);
    }
    
    public double getPrice() {
        return 5 + this.coffee.getPrice();
    }
}

class Main {
    public static void main(String[] args) {
        Coffee myCoffee = new HoneyCoffee(new MilkCoffee(new BasicCoffee()));
        System.out.println("Price of coffee with honey and milk: " + myCoffee.getPrice());
        
        Coffee myCoffee2 = new MilkCoffee(new MilkCoffee(new BasicCoffee()));
        System.out.println("Price of coffee with double milk: " + myCoffee2.getPrice());
    }
}
