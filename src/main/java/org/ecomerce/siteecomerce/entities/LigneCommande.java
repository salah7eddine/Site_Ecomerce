package org.ecomerce.siteecomerce.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LigneCommande implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLineCommande;
    private int quantite;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "idCommande")
    private Commande commande;

    public LigneCommande() {
    }

    public LigneCommande(int quantite, double prix) {

        this.quantite = quantite;
        this.prix = prix;
    }

    public Long getIdLineCommande() {

        return idLineCommande;
    }

    public void setIdLineCommande(Long idLineCommande) {
        this.idLineCommande = idLineCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
