package 对象Long比较;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/01/28
 */
public class Test {
    public static void main(String[] args) {
        User user1 = new User(2L);
        user1.setAge(12D);

        User user2 = new User(2L);
        user2.setAge(12D);

        // 包装类可以直接equal
        if (user1.getId().longValue() == user2.getId().longValue()) {
            if (user1.getId().equals(user2.getId())) {
                System.out.println("=====");
            }

        }

        if (user2.getAge().equals(user2.getAge())) { // true
            System.out.println("==double==");

        }

    }
}
