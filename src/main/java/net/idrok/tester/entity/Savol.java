
package net.idrok.tester.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Savol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String matn;

    @ManyToOne
    private Fan fan;

    @OneToMany(mappedBy = "savol")
    private Set<Variant> variantlar;

    private SavolDaraja savolDaraja;

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



    

}
