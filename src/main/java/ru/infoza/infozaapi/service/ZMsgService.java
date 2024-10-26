package ru.infoza.infozaapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.infoza.infozaapi.model.ZMsg;
import ru.infoza.infozaapi.repository.ZMsgRepository;

import java.util.List;

@Service
public class ZMsgService {
    private final ZMsgRepository zMsgRepository;

    public ZMsgService(ZMsgRepository zMsgRepository) {
        this.zMsgRepository = zMsgRepository;
    }

    public List<ZMsg> getAllVacancyMessages() {
        return zMsgRepository.findByInPART(2, Sort.by(Sort.Direction.DESC, "dtCRE"));
    }

    public Page<ZMsg> getVacancyMessages(Pageable pageable) {
        return zMsgRepository.findByInPART(2, pageable);
    }

    public List<ZMsg> getPersonalMessages(int userId) {
        return zMsgRepository.findByInPARTAndInIstTo(3, userId);
    }
}
