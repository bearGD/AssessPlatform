package edu.csuft.assess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.csuft.assess.mapper")
public class AssessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessApplication.class, args);
	}
}
