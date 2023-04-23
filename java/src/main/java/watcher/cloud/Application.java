package watcher.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("watcher.cloud.mapper")
public class Application {
    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
        System.out.println("*******************************************************************\n");
        System.out.println("Hello World!\n");
        System.out.println("*******************************************************************");
    }
}
