package org.ecomerce.siteecomerce.web;

import org.ecomerce.siteecomerce.dao.ProduitRepository;
import org.ecomerce.siteecomerce.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ProduitRestService {
    @Autowired
    private ProduitRepository produitRepository;

    @RequestMapping(value="/produits",method = RequestMethod.GET)
    private List<Produit> produits(){ return produitRepository.findAll();}

    @RequestMapping(value="/produits/{id}",method = RequestMethod.GET)
    private Optional<Produit> getProduits(@PathVariable Long id){ return produitRepository.findById(id);}

    @RequestMapping(value="/chercherProduit",method = RequestMethod.GET)
    private Page<Produit> chercher(@RequestParam(name = "mc",defaultValue = "") String mc,
                                   @RequestParam(name = "page",defaultValue = "0") int page,
                                   @RequestParam(name = "size",defaultValue = "10") int size){ return produitRepository.chercher("%"+mc+"%",new PageRequest(page,size));}


    @RequestMapping(value="/produits",method = RequestMethod.POST)
    private Produit save(@RequestBody Produit p){ return produitRepository.save(p);}

    @RequestMapping(value="/produits/{id}",method = RequestMethod.DELETE)
    private boolean supprimer(@PathVariable Long id){ produitRepository.deleteById(id); return true;}

    @RequestMapping(value="/produits/{id}",method = RequestMethod.PUT)
    private Produit save(@PathVariable Long id,@RequestBody Produit p){ p.setIdProduit(id); return produitRepository.save(p);}
}
