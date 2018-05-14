package org.ecomerce.siteecomerce;

import org.ecomerce.siteecomerce.dao.CategorieRepository;
import org.ecomerce.siteecomerce.dao.ProduitRepository;
import org.ecomerce.siteecomerce.entities.Categorie;
import org.ecomerce.siteecomerce.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SiteecomerceApplication implements CommandLineRunner{
	@Autowired
	public ProduitRepository produitRepository;
	@Autowired
	public CategorieRepository categorieRepository;

	public static void main(String[] args) {
		SpringApplication.run(SiteecomerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*produitRepository.save(new Produit("produit1","pc1",2344,100,false,"image1.png"));
		produitRepository.save(new Produit("produit2","pc2",5444,50,true,"image2.png"));
		produitRepository.save(new Produit("produit3","pc3",1677,120,false,"image3.png"));*/
		//Categorie(String nomCategorie, String description, byte[] photo, String nomPhoto)
		/*categorieRepository.save(new Categorie("categorie1","desc1",null,"photo1.jpg"));
		categorieRepository.save(new Categorie("categorie2","desc2",null,"photo2.jpg"));
		categorieRepository.save(new Categorie("categorie3","desc3",null,"photo3.jpg"));
*/


		produitRepository.findAll().forEach(c->{
			System.out.println(c.getDesignation());
		});
	}
}
