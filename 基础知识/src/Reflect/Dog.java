package Reflect;

public class Dog extends Object {
    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog() {
    }

    public Dog(int num, String name) {
        this.num = num;
        this.name = name;
    }


}
