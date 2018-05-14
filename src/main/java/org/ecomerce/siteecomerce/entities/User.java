package org.ecomerce.siteecomerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long idUser;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private boolean actived;
    @OneToMany
    @JoinColumn(name = "user_id")
    private Collection<Role> roles;

    public User(String yserName, String password, boolean actived) {
        this.userName = yserName;
        this.password = password;
        this.actived = actived;
    }

    public User() {

    }

    public Long getIdUser() {

        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getYserName() {
        return userName;
    }

    public void setYserName(String yserName) {
        this.userName = yserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
