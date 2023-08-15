package com.example.CricReg.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:MessagesAndCodes.properties")
@Getter
@Setter
public class ValidationFailureResponseCode {
  // Common Success code
  @Value("${code.success.common}")
  private String commonSuccessCode;

  @Value("${code.failure.common}")
  private String failureCode;

  // Validation code for Registration
  @Value("${code.validation.registration.alreadyExists}")
  private String registrationAlreadyExString;

  @Value("${code.validation.registration.notExists}")
  private String registrationNotExistsCode;

  // Messages for registration
  @Value("${message.success.save.registration}")
  private String saveRegistrationSuccessMessage;

  @Value("${message.validation.registration.alreadyExists}")
  private String validationRegistrationAlreadyExists;

  @Value("${message.success.getAll.registration}")
  private String getAllRegistrationSuccessMessage;

  @Value("${message.validation.registration.notExists}")
  private String registrationNotExistsMessage;

  @Value("${message.success.getById.registration}")
  private String getRegistrationByIdSuccessMessage;

  @Value("${message.success.update.registration}")
  private String updateRegistrationSuccessMessage;

  @Value("${message.success.delete.registration}")
  private String deleteRegistrationSuccessMessage;
}

