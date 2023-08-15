package com.example.CricReg.RegistrationResponse;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
public class RegistrationResponse {

//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)

  private Long id;
  private String teamName;
  private String captainName;
  private String contactNumber;
  private String email;
  private String message;

  public RegistrationResponse(String message) {
    this.message = message;
  }
}
