package ru.infoza.infozaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.infoza.infozaapi.model.SUsr;

import java.util.Optional;

public interface SUsrRepository extends JpaRepository<SUsr, Integer> {
    Optional<SUsr> findByVcUSR(String vcUSR);
}