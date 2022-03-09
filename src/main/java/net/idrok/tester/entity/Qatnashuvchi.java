
package net.idrok.tester.entity;

import java.time.LocalDateTime;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Qatnashuvchi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @ManyToOne
    private Imtihon imtihon;

    @ManyToMany
    @JoinTable(
      name = "qatnashuvchi_variant", 
      joinColumns = @JoinColumn(name = "qantashuvchi_id"), 
      inverseJoinColumns = @JoinColumn(name = "variant_id"))
    private Set<Variant> javoblar;

    @ManyToOne
    private User user;

    private Boolean jarayon;

    private LocalDateTime regVaqt;
    private LocalDateTime boshVaqt;
    private LocalDateTime tugVaqt;
    private Integer tugriJavobSon;
    private Integer orin;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Imtihon getImtihon() {
        return imtihon;
    }
    public void setImtihon(Imtihon imtihon) {
        this.imtihon = imtihon;
    }
    public Set<Variant> getJavoblar() {
        return javoblar;
    }
    public void setJavoblar(Set<Variant> javoblar) {
        this.javoblar = javoblar;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Boolean getJarayon() {
        return jarayon;
    }
    public void setJarayon(Boolean jarayon) {
        this.jarayon = jarayon;
    }
    public LocalDateTime getRegVaqt() {
        return regVaqt;
    }
    public void setRegVaqt(LocalDateTime regVaqt) {
        this.regVaqt = regVaqt;
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
    public Integer getTugriJavobSon() {
        return tugriJavobSon;
    }
    public void setTugriJavobSon(Integer tugriJavobSon) {
        this.tugriJavobSon = tugriJavobSon;
    }
    public Integer getOrin() {
        return orin;
    }
    public void setOrin(Integer orin) {
        this.orin = orin;
    }
    
    

}
