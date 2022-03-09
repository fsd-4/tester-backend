
package net.idrok.tester.entity;

import java.time.LocalDateTime;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity
public class Imtihon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne
    private Fan fan;

    @ManyToMany
    @JoinTable(
      name = "imtihon_savol", 
      joinColumns = @JoinColumn(name = "imtihon_id"), 
      inverseJoinColumns = @JoinColumn(name = "savol_id"))
    private Set<Savol> savollar;

    @ManyToOne
    private User user;
    
    private LocalDateTime boshVaqt;
    private LocalDateTime tugVaqt;
    private Boolean jarayon;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Fan getFan() {
        return fan;
    }
    public void setFan(Fan fan) {
        this.fan = fan;
    }
    public Set<Savol> getSavollar() {
        return savollar;
    }
    public void setSavollar(Set<Savol> savollar) {
        this.savollar = savollar;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getBoshVaqt() {
        return boshVaqt;
    }
    public void setBoshVaqt(LocalDateTime boshVaqt) {
        this.boshVaqt = boshVaqt;
    }
    public LocalDateTime getTugVaqt() {
        return tugVaqt;
    }
    public void setTugVaqt(LocalDateTime tugVaqt) {
        this.tugVaqt = tugVaqt;
    }
    public Boolean getJarayon() {
        return jarayon;
    }
    public void setJarayon(Boolean jarayon) {
        this.jarayon = jarayon;
    }


}
