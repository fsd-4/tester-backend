
package net.idrok.tester.entity;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Savol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String matn;

    @Lob
    private byte[] rasm;

    @ManyToOne
    private Fan fan;

    @OneToMany(mappedBy = "savol")
    @JsonBackReference(value = "savol")
    private Set<Variant> variantlar;

    private SavolDaraja savolDaraja;

    @ManyToOne
    private User user;

    private KurishHuquq kurishHuquq;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatn() {
        return matn;
    }

    public void setMatn(String matn) {
        this.matn = matn;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public Set<Variant> getVariantlar() {
        return variantlar;
    }

    public void setVariantlar(Set<Variant> variantlar) {
        this.variantlar = variantlar;
    }

    public SavolDaraja getSavolDaraja() {
        return savolDaraja;
    }

    public void setSavolDaraja(SavolDaraja savolDaraja) {
        this.savolDaraja = savolDaraja;
    }

    public byte[] getRasm() {
        return rasm;
    }

    public void setRasm(byte[] rasm) {
        this.rasm = rasm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public KurishHuquq getKurishHuquq() {
        return kurishHuquq;
    }

    public void setKurishHuquq(KurishHuquq kurishHuquq) {
        this.kurishHuquq = kurishHuquq;
    }



    

}
