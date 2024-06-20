package top.flyeric.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"top.flyeric.demo", "top.flyeric.framework"})
// fix multi beans issue: https://cloud.tencent.com/developer/article/2345682
@MapperScan(basePackages = {"top.flyeric.demo.**.mapper"})
public class ColaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColaDemoApplication.class, args);
    }
}
