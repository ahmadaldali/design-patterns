abstract class Shape {
    public abstract void getMe();
    public abstract void calculate();
}

class Rectangle extends Shape {
    public void getMe() {
        System.out.println("I am calculating as rectangle.");
    }
     
    public void calculate() {
        this.getMe();
        System.out.println("Doing some calculation");
    }
}

abstract class AbstractCalculationAdapter {
    private Shape shape;
       
    public AbstractCalculationAdapter(Shape shape) {
        this.shape=shape;
    }
    
    public void getShape() {
        this.shape.getMe();
    }
        
    public abstract void calculate();
}

class CalculationAdapter extends AbstractCalculationAdapter{
    public CalculationAdapter(Shape shape) {
        super(shape);
    }
    
    public void calculate() {
        this.getShape();
        System.out.println("Here we go with new way of caluclation which is up-to-date. The old way is out-of-date right now.");
    }
}

class Main {
    public static void main(String[] args) {
        Shape recatngle = new Rectangle();
        System.out.println("This is the old calucaltion/system");
        recatngle.calculate();
        
        System.out.println("------------------------");
        
        System.out.println("This is the new calucaltion/adapter");
        AbstractCalculationAdapter newCal = new CalculationAdapter(recatngle);
        newCal.calculate();
    }
}
