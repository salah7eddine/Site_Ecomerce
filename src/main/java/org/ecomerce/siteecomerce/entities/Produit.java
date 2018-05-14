package org.ecomerce.siteecomerce.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "produits")
public class Produit implements Serializable {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
   /*@NotEmpty
    @Size (min = 4, max = 15)*/
    private String designation;
   /*@NotEmpty
    @Size(min = 4,max = 15)*/
    private String description;
    private double prix;
    private int quantite;
    private Boolean selectione;
    @Lob
    private byte[] photo;
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private Collection<LigneCommande> lineCommandes;


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Collection<LigneCommande> getLineCommandes() {
        return lineCommandes;
    }

    public void setLineCommandes(Collection<LigneCommande> lineCommandes) {
        this.lineCommandes = lineCommandes;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Boolean getSelectione() {
        return selectione;
    }

    public void setSelectione(Boolean selectione) {
        this.selectione = selectione;
    }
    @Lob
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Produit(String designation, String description, double prix, int quantite, Boolean selectione, byte[] photo) {

        this.designation = designation;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.selectione = selectione;
        this.photo = photo;
    }

    public Produit() {

    }
}
