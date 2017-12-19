package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = {SpringMain.class, Jsr310JpaConverters.class})

@SpringBootApplication
public class SpringMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringMain.class, args);
	}
}
