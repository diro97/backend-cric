//package com.example.CricReg.ServiceIMPL;
//
//import com.example.CricReg.RegistrationResponse.RegistrationResponse;
//import com.example.CricReg.Repository.RegistrationRepository;
//import com.example.CricReg.RequestRegistration.RegistrationRequest;
//import com.example.CricReg.Service.RegistrationService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.Registration;
//import javax.transaction.Transactional;
//
//@Service
//public class RegistrationIMPL implements RegistrationService {
//
//  private final RegistrationRepository registrationRepository;
//  @Autowired
//  public RegistrationIMPL(RegistrationRepository registrationRepository) {
//    this.registrationRepository = registrationRepository;
//  }
//  @Override
//  @Transactional
//  public void saveRegistration(RegistrationRequest registrationRequest) {
//    Registration registration=new Registration();
//      BeanUtils.copyProperties(registrationRequest,registration);
//    registrationRepository.save(registration);
//    }
//
//}
package com.example.CricReg.ServiceIMPL;
 // Correct import for your custom entity class
import com.example.CricReg.Entity.RegistrationEntity;
import com.example.CricReg.Repository.RegistrationRepository;
import com.example.CricReg.RequestRegistration.RegistrationRequest;
import com.example.CricReg.Service.RegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationIMPL implements RegistrationService {
  @Autowired
  private  RegistrationRepository registrationRepository;

@Transactional
  @Override
  public void saveRegistration(RegistrationRequest registrationRequest) {
    RegistrationEntity registration = new RegistrationEntity();
    BeanUtils.copyProperties(registrationRequest, registration);
    registrationRepository.save(registration);
  }

  @Override
  public List<RegistrationEntity> getAllDetails() {
    return registrationRepository.findAll();
  }

  @Override
  public void deleteRegistration(Long id) {
   registrationRepository.deleteById(id);
  }

  @Override
  public boolean existsByRegistration(Long id) {
    return registrationRepository.existsById(id);
  }

  @Override
  public boolean existsByTeamName(String teamName) {
    return registrationRepository.existsByTeamName(teamName);
  }

  @Override
  public boolean getDetailsByRegistration(Long id) {
    return registrationRepository.existsById(id);
  }

  @Override
  public Optional<RegistrationEntity> getDetailsByTeamName(String teamName) {
    return registrationRepository.findByTeamName(teamName);
  }


}
