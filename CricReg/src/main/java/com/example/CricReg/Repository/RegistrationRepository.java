package com.example.CricReg.Repository;

import com.example.CricReg.Entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity,Long> {

  boolean existsByTeamName(String teamName);

  Optional<RegistrationEntity> findByTeamName(String teamName);


}
