package connect.go;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoApplication.class, args);
	}

}
