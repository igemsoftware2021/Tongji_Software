package cn.edu.tongji.software_igem2021.igemwebbackend;

import org.mapstruct.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://localhost:8080", "http://47.100.225.207", "null"})
@SpringBootApplication
@MapperConfig
public class IgemWebBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgemWebBackendApplication.class, args);
    }

}
