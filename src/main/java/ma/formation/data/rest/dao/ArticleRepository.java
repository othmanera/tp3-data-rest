package ma.formation.data.rest.dao;

import ma.formation.data.rest.domaine.ArticleDTO;
import ma.formation.data.rest.service.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

//est une annotation qui configure le référentiel
// "ArticleRepository" pour être exposé en tant que service REST.

//collectionResourceRel = "articles" : Cela définit la relation entre la ressource de
// la collection et le nom de la ressource dans le service REST.
// Dans cet exemple, les articles seront accessibles via le chemin
// "/articles" dans le service REST.

// path = "ecommerce" : Cela spécifie le chemin de base pour le référentiel dans
// le service REST. Ainsi, le chemin complet pour accéder aux articles sera "/ecommerce/articles".

// exerptProjection :  indique que la classe "ArticleDTO" sera utilisée pour gérer
// les projections d'extraits
@RepositoryRestResource(collectionResourceRel = "articles", path = "ecommerce", excerptProjection = ArticleDTO.class)
//  Cela signifie que le référentiel aura des méthodes pour effectuer des opérations CRUD
//  (Create, Read, Update, Delete) sur l'entité "Article" associée, qui a un identifiant de type "Long"
public interface ArticleRepository extends JpaRepository<Article, Long> {

    // Cela spécifie le chemin pour accéder à
    // cette méthode personnalisée, qui sera "/ecommerce/search/byDescription
    @RestResource(path = "byDescription", rel = "customFindByDescription")
    //Cette méthode personnalisée recherche des articles par leur description.
    //@Pram: pour associer le paramètre "description" à la valeur passée dans la requête HTTP
    List<Article> findByDescription(@Param("description") String description);

}
