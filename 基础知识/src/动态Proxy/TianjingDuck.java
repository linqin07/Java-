package 动态Proxy;

public class TianjingDuck implements Duck {

    @Override
    public void create(int weigth) {
        System.out.println("制作" + weigth + "斤重的天津烤鸭");
    }
}
