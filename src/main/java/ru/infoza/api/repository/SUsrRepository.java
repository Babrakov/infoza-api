package ru.infoza.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.infoza.api.domain.SUsr;

public interface SUsrRepository extends JpaRepository<SUsr, Integer> {

    Optional<SUsr> findByVcUSR(String vcUSR);
}