package ru.infoza.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.infoza.api.domain.ZPho;
import ru.infoza.api.dto.ZPhoInfoDTO;

public interface ZPhoRepository extends CrudRepository<ZPho, Integer> {

    @Query("SELECT new ru.infoza.api.dto.ZPhoInfoDTO(p.dtCRE, l.inTIP, i.vcORG) " +
            "FROM ZPho p " +
            "JOIN Lnzp l ON p.idZP = l.idZP " +
            "JOIN ZIst i ON l.inIST = i.idIST " +
            "WHERE p.vcPHO = :vcPHO")
    List<ZPhoInfoDTO> findPersonalMessagesByVcPho(String vcPHO);

}
