enum AnimalTypes {
    DOG,
    DUCK,
    OTHER
}

interface Animal {
    public void speak();
}

class Dog implements Animal {
    public void speak() {   
        System.out.println("Barking ...");
    }
}

class Duck implements Animal {
    public void speak() {   
        System.out.println("Quacking ...");
    }
}

class UnkownAnimal implements Animal {
    public void speak() {   
        System.out.println("unkowing ...");
    }
}

// abstract factory
abstract class AbstractAnimalFactory {
    public abstract Animal createAnimal(AnimalTypes type);
}

// factory method
class AnimalFactory extends AbstractAnimalFactory {
    public Animal createAnimal(AnimalTypes type) {
        switch(type) {
            case DOG:
                return new Dog();
            case DUCK:
                return new Duck();
            default:
                return new UnkownAnimal();
        }
    }
}

class Main {
    public static void main(String[] args) {
        AbstractAnimalFactory factoryObj = new AnimalFactory();
        
        Animal dog = factoryObj.createAnimal(AnimalTypes.DOG);
        dog.speak();
        
        Animal duck = factoryObj.createAnimal(AnimalTypes.DUCK);
        duck.speak();
    
        Animal unkown = factoryObj.createAnimal(AnimalTypes.OTHER);
        unkown.speak();
    }
}
