package com.example.CricReg.Service;

import com.example.CricReg.Entity.RegistrationEntity;
import com.example.CricReg.RequestRegistration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface RegistrationService {
  public void saveRegistration(RegistrationRequest registrationRequest);

  List<RegistrationEntity> getAllDetails();

  public void deleteRegistration(Long id);

  public boolean existsByRegistration(Long id);

  public boolean existsByTeamName(String teamName);

  public boolean getDetailsByRegistration(Long id);

  public Optional<RegistrationEntity> getDetailsByTeamName(String teamName);

}
