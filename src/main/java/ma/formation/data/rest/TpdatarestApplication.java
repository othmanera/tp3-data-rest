package ma.formation.data.rest;

import ma.formation.data.rest.service.IService;
import ma.formation.data.rest.service.model.Article;
import ma.formation.data.rest.service.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpdatarestApplication {
	@Autowired
	private IService service;
	public static void main(String[] args) {
		SpringApplication.run(TpdatarestApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase() throws Exception {
		return (a) -> {
			var categorie1 = new Categorie("CATEGORIE_1");
			var categorie2 = new Categorie("CATEGORIE_2");
			var categorie3 = new Categorie("CATEGORIE_3");

			var article1 = new Article("Article_1", 120d, 10d);
			var article2 = new Article("Article_2", 6000d, 30d);
			var article3 = new Article("Article_3", 7000d, 44d);
			var article4 = new Article("Article_4", 12000.0, 5d);
			var article5 = new Article("Article_5", 12000.0, 5d);

			service.save(categorie1, article1, article2);
			service.save(categorie2, article3, article4);
			service.save(categorie3, article5);
		};
	}

}
