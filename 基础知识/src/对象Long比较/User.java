package 对象Long比较;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/01/28
 */
public class User {
    private Long id;

    private Double age;

    public User(Long id) {
        this.id = id;
    }

    public User(Double age) {
        this.age = age;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
