package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	//스프링은 기본적인 메모리 관리 기능을 제공한다 -> ResourceBundleMessageSource 스프링 빈 등록
}
