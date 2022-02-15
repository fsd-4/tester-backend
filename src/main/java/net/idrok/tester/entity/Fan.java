package net.idrok.tester.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String nom;

    private String malumot;

    private FanDaraja fanDaraja;

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

    public String getMalumot() {
        return malumot;
    }

    public void setMalumot(String malumot) {
        this.malumot = malumot;
    }

    public FanDaraja getFanDaraja() {
        return fanDaraja;
    }

    public void setFanDaraja(FanDaraja fanDaraja) {
        this.fanDaraja = fanDaraja;
    }


    

}
