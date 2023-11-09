package ma.formation.data.rest.service;

import ma.formation.data.rest.dao.CategorieRepository;
import ma.formation.data.rest.service.model.Article;
import ma.formation.data.rest.service.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceImpl implements IService{

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public void save(Categorie cat, Article... articleList) {
        // À chaque itération de la boucle, cette ligne ajoute
        // l'article "a" à la liste d'articles de la catégorie "cat"
        for (Article a : articleList) {
            a.setCategorie(cat);
            cat.getArticles().add(a);
        }

// Après avoir associé tous les articles à la catégorie, cette ligne enregistre la catégorie
// (et les articles associés) en appelant la méthode save sur le référentiel (repository)
// de catégories (categorieRepository). Cela peut persister les données dans une base de données
// ou effectuer d'autres actions nécessaires pour sauvegarder les modifications.
        categorieRepository.save(cat);
    }
}
