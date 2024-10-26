package ru.infoza.infozaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.infoza.infozaapi.model.ZIst;

import java.util.Optional;

@Repository
public interface ZIstRepository extends JpaRepository<ZIst, Integer> {
    Optional<ZIst> findByVcUSR(String vcUSR);
}
