package org.ecomerce.siteecomerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
public class Categorie implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
  /*  @NotEmpty
    @Size(min=4,max = 20)*/
    private String nomCategorie;
   // @Size(min=8)
    private String description;
    @Lob
    private byte[] photo;
    private String nomPhoto;
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;

    public Categorie(String nomCategorie, String description, byte[] photo, String nomPhoto) {
        this.nomCategorie = nomCategorie;
        this.description = description;
        this.photo = photo;
        this.nomPhoto = nomPhoto;
    }

    public Categorie() {

    }

    public Long getIdCategorie() {

        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNomPhoto() {
        return nomPhoto;
    }

    public void setNomPhoto(String nomPhoto) {
        this.nomPhoto = nomPhoto;
    }
    @JsonIgnore
    @XmlTransient
    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}




