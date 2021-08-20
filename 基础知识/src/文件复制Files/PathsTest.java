package 文件复制Files;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/07/23
 */
public class PathsTest {
    public static void main(String[] args) {
        Path path = Paths.get("/data/zhang");
        Path path1 = Paths.get("/data/zhang/");
        if (path.equals(path1)) System.out.println("ggggggggg");
        System.out.println(path.toString());

        Path path2 = Paths
                .get("/var/lib/docker/containers/shared-data-busi-9mae8na3/01014002-c014-01014002-3300-1-7c5696d454-6mzk7-aoplog.log");
        System.out.println(path2.getParent());

        URI uri = URI.create("http://192.168.13.10:8080//sdfs");
        System.out.println(uri.getPath()
        );
    }
}
