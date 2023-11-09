package ma.formation.data.rest.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

//@ Entity : Cette annotation indique que la classe Article est
// une entité JPA, ce qui signifie qu'elle sera associée à une table dans une base de données
@Entity
@Data
@NoArgsConstructor
public class Article {
// @Id : la clé primaire de l'entité.
// @GeneratedValue : Elle indique que la valeur de la clé primaire (id) sera
// générée automatiquement par la base de données lors de l'insertion d'un nouvel enregistrement.
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double price;
    private Double quantity;
// Cette annotation indique qu'il s'agit d'une relation many-to-one entre l'entité Article
// et une autre entité (Categorie). Une relation many-to-one signifie qu'un article
// peut être associé à une seule catégorie, tandis qu'une catégorie peut être associée
// à plusieurs articles.
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    //Cette annotation permet de spécifier la colonne de la base de
    // données qui sera utilisée pour stocker la clé étrangère de la relation many-to-one
    private Categorie categorie;

    public Article(String description, Double price, Double quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
