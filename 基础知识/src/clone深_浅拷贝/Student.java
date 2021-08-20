package clone深_浅拷贝;

public class Student implements Cloneable {

    private String name;
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String string) {
        this.name = string;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.teacher = (Teacher) teacher.clone();
        return student;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", teacher=" + teacher + "]";
    }

}
