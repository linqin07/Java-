package clone深_浅拷贝;

public class Test {
    /**
     * 创建对象：new、反射newinstance、clone
     * <p>
     * 实体类实现Cloneable接口就可以调用clone方法，注意这个对象如果不是基本数据类型，是一些自定义的复杂类型时
     * 复制就是 浅拷贝（复杂对象是引用的） 想要 深拷贝 。
     * <p>
     * 1.复杂对象统一实现Cloneable而且重写clone()方法 。
     * 2.把复制的实体类的clone()重写，里面不仅仅对自己super.clone(),同时对复制对象也clone()。
     * <p>
     * protected Object clone() throws CloneNotSupportedException {
     * Student student = (Student) super.clone();
     * student.teacher = (Teacher) teacher.clone();
     * return student;
     * }
     *
     * @throws CloneNotSupportedException 另外：集合类是没有Cloneable和Serializable接口
     *                                    因为：单单克隆一个集合是没有意义的，重点是里面装的内容。所以要手动实现
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student(); //对象中没有复杂类型时
        student.setName("张三");

        Teacher teacher = new Teacher();
        teacher.setName("张三老师");
        student.setTeacher(teacher);

        Student clone = (Student) student.clone();
        teacher.setName("李四老师");

        System.out.println(student.toString());
        System.out.println(clone.toString());

    }

}
