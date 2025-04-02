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

class AnimalFactory {
    public static Animal createAnimal(AnimalTypes type) {
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
        Animal dog = AnimalFactory.createAnimal(AnimalTypes.DOG);
        dog.speak();
        
        Animal duck = AnimalFactory.createAnimal(AnimalTypes.DUCK);
        duck.speak();
    
        Animal unkown = AnimalFactory.createAnimal(AnimalTypes.OTHER);
        unkown.speak();
    }
}
