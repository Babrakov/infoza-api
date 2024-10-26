package ru.infoza.infozaapi.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.infoza.infozaapi.domain.SUsr;

public interface SUsrRepository extends JpaRepository<SUsr, Integer> {

    Optional<SUsr> findByVcUSR(String vcUSR);
}