package com.Microservices.ConsumerService.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Ens")
public class Enseignant {
    @Id
    private Long id_Ens;
    private String nom;
    private String prenom;
    private String email;
    private String grade;


    // Constructeur par défaut
    public Enseignant() {
    }

    // Getters et Setters

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

    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Méthode toString pour l'affichage
    @Override
    public String toString() {
        return "Enseignant{" +
                "id_Ens=" + id_Ens +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }


}