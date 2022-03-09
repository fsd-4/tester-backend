package net.idrok.tester.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(nullable = false, length = 30)
    private String ism;

    @Size(max = 30)
    @Column(length = 30)
    private String familiya;

    @NotNull
    @Size(min = 6, max = 30)
    @Column(nullable = false, length = 30, unique = true)
    private String login;

    @NotNull
    @Size(min = 6, max = 30)
    @Column(nullable = false, length = 30)
    private String parol;

    private LocalDateTime regVaqt;
    private LocalDateTime oxirgiTashrif;

    
    private Role role;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIsm() {
        return ism;
    }
    public void setIsm(String ism) {
        this.ism = ism;
    }
    public String getFamiliya() {
        return familiya;
    }
    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getParol() {
        return parol;
    }
    public void setParol(String parol) {
        this.parol = parol;
    }
    public LocalDateTime getRegVaqt() {
        return regVaqt;
    }
    public void setRegVaqt(LocalDateTime regVaqt) {
        this.regVaqt = regVaqt;
    }
    public LocalDateTime getOxirgiTashrif() {
        return oxirgiTashrif;
    }
    public void setOxirgiTashrif(LocalDateTime oxirgiTashrif) {
        this.oxirgiTashrif = oxirgiTashrif;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }


    

}
