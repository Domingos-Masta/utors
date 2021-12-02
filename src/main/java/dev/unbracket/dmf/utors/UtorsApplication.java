package dev.unbracket.dmf.utors;

import dev.unbracket.dmf.utors.files.FileEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileEntity.class)
public class UtorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtorsApplication.class, args);
    }

}
