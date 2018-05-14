package org.ecomerce.siteecomerce.web;

import org.ecomerce.siteecomerce.dao.CategorieRepository;
import org.ecomerce.siteecomerce.entities.Categorie;
import org.ecomerce.siteecomerce.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CategorieRestService {

    @Autowired
    private CategorieRepository categorieRepository;

    @RequestMapping(value="/categories",method= RequestMethod.GET)
    public List<Categorie> listCategories(){ return categorieRepository.findAll();}

    @RequestMapping(value="/categories/{id}",method = RequestMethod.GET)
    private Optional<Categorie> getCategorie(@PathVariable Long id){ return categorieRepository.findById(id);}


    @RequestMapping(value="/chercherCategories",method = RequestMethod.GET)
    private Page<Categorie> chercher(@RequestParam(name = "mc",defaultValue = "") String mc,
                                     @RequestParam(name = "page",defaultValue = "0") int page,
                                     @RequestParam(name = "size",defaultValue = "10") int size){ return categorieRepository.chercher("%"+mc+"%",new PageRequest(page,size));}

    @RequestMapping(value="/ajouterCategories",method=RequestMethod.POST)
    public Categorie save(@RequestBody  Categorie cat){ return  categorieRepository.save(cat);}


    @RequestMapping(value="/categories/{id}",method = RequestMethod.DELETE)
    public boolean supprimer(@PathVariable Long id){ categorieRepository.deleteById(id); return true;}


    @RequestMapping(value="/categories/{id}",method=RequestMethod.PUT)
    private Categorie update(@PathVariable Long id,@RequestBody Categorie cat){
        cat.setIdCategorie(id);
        return categorieRepository.save(cat);

    }
}



