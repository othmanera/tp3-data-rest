package ma.formation.data.rest;

import ma.formation.data.rest.service.model.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// une classe de test utilisant le framework de test unitaire Spring Boot pour tester un service REST
// Cette annotation indique que c'est une classe de test Spring Boot et que l'application
// Spring Boot sera exécutée dans un environnement avec un port aléatoire (RANDOM_PORT)

// Cela signifie que l'application sera démarrée sur un port aléatoire,
// ce qui est utile pour éviter les conflits de port avec d'autres applications.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TpdatarestApplicationTests {

	// Cette annotation injecte le contexte Web de l'application.
	// Le contexte Web est utilisé pour configurer et exécuter les tests Web
	// (les composants web : servelet,...).
	@Autowired
	WebApplicationContext context;

	//MockMvc pour effectuer des requêtes HTTP simulées sur des points de terminaison REST de
	// l'application et vérifie les réponses pour s'assurer que les opérations REST
	// fonctionnent correctement.

	//MockMvc est un module de SpringTest permettant de simplifier la création de tests Rest
	private MockMvc mvc;

	@BeforeEach
	void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

//Ces tests permettent de vérifier si l'application répond correctement
// aux requêtes et renvoie les données attendues.
	@Test
	void testGetAllArticles() throws Exception {
// Cette méthode de test vérifie la récupération de tous les articles en effectuant
// une requête HTTP GET sur l'URL "/articles" et en vérifiant la réponse.
// mvc.perform(...): Cette ligne effectue une requête HTTP GET
//simulée sur "/articles" avec le type de contenu JSON.

		mvc.perform(get("/articles").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				//Vérifie que le code de statut de la réponse est OK.
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded.articles[0].description").value("Article_1"))
				.andExpect(jsonPath("$._embedded.articles[0].price").value(120))
				.andExpect(jsonPath("$._embedded.articles[0].quantity").value(10));
	}

	@Test
	void testGetArticleById() throws Exception {

		Article article = new Article("Article_1", 120d, 10d);

		mvc.perform(get("/ecommerce/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.description").value("Article_1"))
				.andExpect(jsonPath("$.price").value(120D))
				.andExpect(jsonPath("$.quantity").value(10D));
	}


}
