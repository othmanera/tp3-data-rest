package ma.formation.data.rest.domaine;

import ma.formation.data.rest.service.model.Article;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;


//Cette annotation @Projection est utilisée pour déclarer une projection appelée "articleDTO"
// pour l'entité de type Article. Cela signifie que cette projection
// sera utilisée pour extraire des données à partir de l'entité Article dans certaines requêtes.

//L’annotation @Projection de Spring Data Rest permet de préciser les projections des
//données à transférer via Rest.
@Projection(name = "articleDTO", types = Article.class)
public interface ArticleDTO {
    Long getId();

  // Cette annotation est utilisée pour définir une méthode
  // dans une projection qui renverra la valeur de la propriété "description" de l'objet cible.
  // @Value("#{target.description}") indique à Spring d'extraire la valeur de la propriété
  // "description" de l'objet cible.

  //#{target (objet).description} : Spring Data REST pour accéder à la propriété "description" de l'objet cible
    @Value("#{target.description}")
    String getDesc();

    Double getPrice();

    @Value("#{target.quantity}")
    Double getQuant();

    @Value("#{target.categorie.categorie}")
    String getCat();
}
