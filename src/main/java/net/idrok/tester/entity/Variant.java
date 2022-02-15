package net.idrok.tester.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String matn;

    private Boolean tugri;

    @ManyToOne
    private Savol savol;

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

    public Boolean getTugri() {
        return tugri;
    }

    public void setTugri(Boolean tugri) {
        this.tugri = tugri;
    }

    public Savol getSavol() {
        return savol;
    }

    public void setSavol(Savol savol) {
        this.savol = savol;
    }

    

}
