package ma.formation.data.rest.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;
//Cette annotation est utilisée pour spécifier des propriétés de la colonne associée au champ
// categorie dans la table de la base de données. unique = true signifie que les valeurs dans
// cette colonne doivent être uniques, c'est-à-dire qu'il ne peut y avoir qu'une seule catégorie
// avec le même nom.
    @Column(unique = true)
    private String categorie;
//Cette annotation indique qu'il s'agit d'une relation one-to-many entre l'entité Categorie et
// l'entité Article. Une relation one-to-many signifie qu'une catégorie peut être associée
// à plusieurs articles
// mappedBy = "categorie" : Spécifie que la relation est gérée par le champ categorie dans
// la classe Article
// cascade = CascadeType.ALL indique que les opérations
// de cascade (par exemple, la suppression d'une catégorie) seront propagées aux articles associés.
//  List<Article> : la collection d'articles associés à cette catégorie
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    public Categorie(String categorie) {
        this.id = id;
        this.categorie = categorie;
    }
}
