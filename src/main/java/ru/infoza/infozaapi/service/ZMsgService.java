package ru.infoza.infozaapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.infoza.infozaapi.domain.ZIst;
import ru.infoza.infozaapi.domain.ZMsg;
import ru.infoza.infozaapi.repository.ZMsgRepository;

@Service
public class ZMsgService {

    private final ZMsgRepository zMsgRepository;
    private final ZIstService zIstService;

    public ZMsgService(ZMsgRepository zMsgRepository, ZIstService zIstService) {
        this.zMsgRepository = zMsgRepository;
        this.zIstService = zIstService;
    }

    public List<ZMsg> getAllVacancyMessages() {
        return zMsgRepository.findByInPART(2, Sort.by(Sort.Direction.DESC, "dtCRE"));
    }

    public Page<ZMsg> getVacancyMessages(Pageable pageable) {
        return zMsgRepository.findByInPART(2, pageable);
    }

    public List<ZMsg> getPersonalMessages(Authentication user) {
        String userName = user.getPrincipal().toString();
        Optional<ZIst> optionalZIst = zIstService.getUserByVcUSR(userName);
        return optionalZIst.map(zIst -> zMsgRepository.findByInPARTAndInIstTo(3, zIst.getIdIST()))
                .orElseGet(Collections::emptyList);
    }
}
