package kh.com.kshrd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="kh.com.kshrd.repositories")
@EntityScan(basePackages="kh.com.kshrd.entities")
public class WeBillIntegrationApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WeBillIntegrationApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WeBillIntegrationApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner demo(BillRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Biller("B001", "Bauer"));
			repository.save(new Biller("B002", "O'Brian"));
			repository.save(new Biller("B003", "Bauer"));
			repository.save(new Biller("B004", "Palmer"));
			repository.save(new Biller("B005", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Biller biller : repository.findAll()) {
				log.info(biller.toString());
				System.out.println(biller.toString());
			}
			for (Biller biller : repository.findBybillerName("Bauer")) {
				log.info(biller.toString());
				System.out.println(biller.toString());
			}
		};
	}*/
}
