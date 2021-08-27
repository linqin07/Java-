package 线程;

class Eat extends Thread {
    @Override
    public void run() {
        System.out.println("I am eating");
    }
}

class Drink implements Runnable{
    @Override
    public void run() {
        System.out.println("I am drinking");
    }

}
public class test1{
    public static void main(String[] args) {
        Eat eat=new Eat();
        eat.start();

        Drink drink=new Drink();
        new Thread(drink).start();
    }
}





