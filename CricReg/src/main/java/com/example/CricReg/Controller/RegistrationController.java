package com.example.CricReg.Controller;

import com.example.CricReg.CommonResponse.BaseResponse;
import com.example.CricReg.Entity.RegistrationEntity;
import com.example.CricReg.Repository.RegistrationRepository;
import com.example.CricReg.RequestRegistration.RegistrationRequest;
import com.example.CricReg.Service.RegistrationService;

import com.example.CricReg.utils.ValidationFailureResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@CrossOrigin("http://localhost:3000/")
public class RegistrationController {

  @Autowired
  ValidationFailureResponseCode validationFailureResponseCode;
  @Autowired
  private RegistrationService registrationService;

  @Autowired
  private RegistrationRepository registrationRepository;

  private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

  @PostMapping("/register")
  public ResponseEntity<BaseResponse> saveRegistration(@RequestBody RegistrationRequest registrationRequest) {
    if(registrationService.existsByTeamName(registrationRequest.getTeamName()))
    {
      return ResponseEntity.ok(new BaseResponse(validationFailureResponseCode.getFailureCode(),
          validationFailureResponseCode.getValidationRegistrationAlreadyExists()));
    }

    registrationService.saveRegistration(registrationRequest);
    return ResponseEntity.ok(new BaseResponse(validationFailureResponseCode.getCommonSuccessCode(),
        validationFailureResponseCode.getSaveRegistrationSuccessMessage()));
  }


  @GetMapping("/details")
  public List<RegistrationEntity> getAllDetails() {
    return registrationRepository.findAll();
  }

  @GetMapping("/getById/{id}")
  public ResponseEntity<?>getDetailsById(@PathVariable Long id) {

    Optional<RegistrationEntity> registrationEntity = registrationRepository.findById(id);

    if (!registrationService.existsByRegistration(id)) {
      return ResponseEntity.ok("Team is not there"); // Return 404 Not Found status
    } else {
      return ResponseEntity.ok(registrationEntity);
    }
  }
  @GetMapping("/getByName/{teamName}")
  public ResponseEntity<?> getDetailsByName(@PathVariable String teamName) {
    Optional<RegistrationEntity> teamDetails = registrationService.getDetailsByTeamName(teamName);

    if (registrationService.existsByTeamName(teamName)) {
      return ResponseEntity.ok(teamDetails);
    } else {
      return ResponseEntity.ok("Team does not exist");
    }
  }



  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteRegistration(@PathVariable Long id) {
    if (!registrationService.existsByRegistration(id)) {
      return ResponseEntity.ok("Team is not exists");
    } else {
      registrationService.deleteRegistration(id);
      return ResponseEntity.ok("Deleted Successfully");
    }
  }
}
