package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Passport")
public class Passport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "personality_id", referencedColumnName = "id")
    private Personality personality;

    @Column(name = "passport_number")
    private int passportNumber;

    public Passport(){

    }

    public Passport(int passportNumber){
        this.personality = personality;
        this.passportNumber = passportNumber;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "personality=" + personality +
                ", passportNumber=" + passportNumber +
                '}';
    }
}
