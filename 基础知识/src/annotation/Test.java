package annotation;

public class Test {

    public static void main(String[] args) throws Exception {
        Factory factory = new FactoryImpl();
        Object object = factory.create(Singleton.class);
        Object object2 = factory.create(Singleton.class);
        System.out.println(object == object2);

        int i = 90;

        char cj = i >= 90 ? 'A' : i >= 80 ? 'B' : 'C';
        char cj1 = i >= 90 ? 'A' : 'D';
    }

}
