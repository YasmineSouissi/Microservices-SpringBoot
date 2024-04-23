package com.Microservices.ConsumerService.AddEvent;

public class AddEvent {
    private Long id_Ens;
    private String nom;
    private String prenom;
    private String email;
    private String grade;

    // Constructeurs, getters et setters
    public AddEvent() {
    }

    public AddEvent(Long id_Ens, String nom, String prenom, String email, String grade) {
        this.id_Ens = id_Ens;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
    }

    public Long getId_Ens() {
        return id_Ens;
    }

    public void setId_Ens(Long id_Ens) {
        this.id_Ens = id_Ens;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "AddEvent{" +
                "id_Ens=" + id_Ens +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
    public Long getEnseignantId() {
        return this.id_Ens;
    }

}
