class SingeltonDemo {
    private static SingeltonDemo instance;
   
    private SingeltonDemo(){};
    
    public static SingeltonDemo getInstance(){
        if (instance == null) {
            System.out.println("initiating ...");
            instance = new SingeltonDemo();
        } else {
            System.out.println("initiated");   
        }
        return instance;
    }
}

class Main {
    public static void main(String[] args) {
        SingeltonDemo instance1 = SingeltonDemo.getInstance();
        SingeltonDemo instance2 = SingeltonDemo.getInstance();
        SingeltonDemo instance3 = SingeltonDemo.getInstance();
    }
}
