package org.ecomerce.siteecomerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @OneToMany(mappedBy = "commande")
    private Collection<LigneCommande> items;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    public Commande() {
    }

    public Long getIdCommande() {

        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Collection<LigneCommande> getItems() {
        return items;
    }

    public void setItems(Collection<LigneCommande> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
