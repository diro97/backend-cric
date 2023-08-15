package com.example.CricReg.RequestRegistration;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
public class RegistrationRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  private Long id;
  private String teamName;
  private String captainName;
  private String contactNumber;
  private String email;
}

