package com.example.CricReg.CommonResponse;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {


  private String statusCode;
  private String message;

  public BaseResponse( String statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }
}

