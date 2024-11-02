package ru.infoza.infozaapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.infoza.infozaapi.dto.ZPhoInfoDTO;
import ru.infoza.infozaapi.repository.ZPhoRepository;

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
