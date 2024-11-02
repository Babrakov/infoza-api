package ru.infoza.infozaapi.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.infoza.infozaapi.domain.ZMsg;

public interface ZMsgRepository extends JpaRepository<ZMsg, Integer> {

    List<ZMsg> findByInPART(Integer inPART, Sort sort);

    Page<ZMsg> findByInPART(Integer inPART, Pageable pageable);

    List<ZMsg> findByInPARTAndInIstTo(Integer inPART, Integer inIstTo);

}
