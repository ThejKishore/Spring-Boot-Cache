package com.kish.app.pojo;

/**
 * Created by ThejKishore on 4/30/2017.
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ThejKishore on 1/28/2017.
 */


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class  Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    private String firstName;

    private String lastName;

    private String mailId;

    private String address;

    public Person(){}

}
