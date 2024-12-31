package ru.infoza.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.infoza.api.domain.ZIst;

@Repository
public interface ZIstRepository extends JpaRepository<ZIst, Integer> {

    Optional<ZIst> findByVcUSR(String vcUSR);
}
