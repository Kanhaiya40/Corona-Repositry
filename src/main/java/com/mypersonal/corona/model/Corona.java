package com.mypersonal.corona.model;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
public class Corona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;
    private String countryName;
    private int affected;
    private int cured;
    private int death;

   public Corona()
    {

    }

     public Corona(String ja, int i1, int i2,int i3) {
        this.countryName=ja;
        this.affected=i1;
        this.cured=i2;
        this.death=i3;

    }
}
