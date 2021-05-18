package com.iquestgroup.remotelearning.week16.w16p1.models;

import com.iquestgroup.remotelearning.week16.w16p1.Gender;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "student")
public class Student {

  @Id
  private int id;

  private String name;

  private String cnp;

  private Gender sex;

  private LocalDate dateOfBirth;

  @ManyToOne
  @JoinColumn(name = "address_id")
  private Address address;
}
