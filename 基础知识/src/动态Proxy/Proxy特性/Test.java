package 动态Proxy.Proxy特性;

public class Test {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        ObjectProxy proxy = new ObjectProxy(orderService);
        orderService = (OrderService) proxy.getProxy();
        orderService.test1();
//        orderService.test2();
    }
}
