package 动态Proxy;

public class BeijingDuck implements Duck {

    @Override
    public void create(int weigth) {
        System.out.println("制作" + weigth + "斤重的北京烤鸭");
    }
}
