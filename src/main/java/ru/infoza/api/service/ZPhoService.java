package ru.infoza.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.infoza.api.dto.ZPhoInfoDTO;
import ru.infoza.api.repository.ZPhoRepository;

@Service
public class ZPhoService {

    private final ZPhoRepository zPhoRepository;

    @Autowired
    public ZPhoService(ZPhoRepository zPhoRepository) {
        this.zPhoRepository = zPhoRepository;
    }

    public List<ZPhoInfoDTO> getPersonalMessages(String vcPHO) {
        return zPhoRepository.findPersonalMessagesByVcPho(vcPHO);
    }

}
