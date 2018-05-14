package org.ecomerce.siteecomerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Client implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nomClient;
    private String adresse;
    private String email;
    private String tel;
    @OneToMany(mappedBy = "client")
    private Collection<Commande> commandes;

    public Client(String nomClient, String adresse, String email, String tel) {
        this.nomClient = nomClient;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
    }

    public Client() {

    }

    public Long getIdClient() {

        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
}
