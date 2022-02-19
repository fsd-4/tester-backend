package net.idrok.tester.service.dto;

import java.util.Set;

import net.idrok.tester.entity.Fan;
import net.idrok.tester.entity.Savol;
import net.idrok.tester.entity.SavolDaraja;
import net.idrok.tester.entity.Variant;

public class SavolDTO {

    private Long id;
    private String matn;
    private Fan fan;
    private Set<Variant> variantlar;
    private SavolDaraja savolDaraja;


    

    public SavolDTO() {
    }
    public SavolDTO(Savol savol) {
        this.id = savol.getId();
        this.fan = savol.getFan();
        this.matn = savol.getMatn();
        this.savolDaraja = savol.getSavolDaraja();
        this.variantlar = savol.getVariantlar();
    }
    public SavolDTO(Long id, String matn, Fan fan, Set<Variant> variantlar, SavolDaraja savolDaraja) {
        this.id = id;
        this.matn = matn;
        this.fan = fan;
        this.variantlar = variantlar;
        this.savolDaraja = savolDaraja;
    }
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
