package com.example.countrymanager.model;
import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;

@Entity

public class Country {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryname;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryname='" + countryname + '\'' +
                ", nationallanguage='" + nationallanguage + '\'' +
                ", population=" + population +
                ", dbupdatedate=" + dbupdatedate +
                '}';
    }

    private String nationallanguage;
    private float population;
    private LocalDate dbupdatedate;




    public Country(){}

    Country(Long idx,String countryname,String nationallanguage,float population,LocalDate dbupdatedate){
        this.id=id;
        this.countryname=countryname;
        this.nationallanguage=nationallanguage;
        this.population=population;
        this.dbupdatedate=dbupdatedate;

    }

    public Long getId(){
        return this.id;
    }
    public String getCountryname(){
        return this.countryname;
    }

    public String getNationallanguage() {
        return nationallanguage;
    }

    public float getPopulation() {
        return population;
    }

    public LocalDate getDbupdatedate() {
        return dbupdatedate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public void setNationallanguage(String nationallanguage) {
        this.nationallanguage = nationallanguage;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public void setDbupdatedate(LocalDate dbupdatedate) {
        this.dbupdatedate = dbupdatedate;
    }


}
