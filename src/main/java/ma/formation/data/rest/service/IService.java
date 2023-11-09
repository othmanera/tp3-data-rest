package ma.formation.data.rest.service;

import ma.formation.data.rest.service.model.Article;
import ma.formation.data.rest.service.model.Categorie;

public interface IService {
    // la liste des paramètres de la méthode
    // Article... articles : vous pouvez passer un ou plusieurs objets de type "Article"
    // séparés par des virgules.
    void save(Categorie cat, Article... articles);
}
