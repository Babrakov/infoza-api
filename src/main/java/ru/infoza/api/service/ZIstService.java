package ru.infoza.api.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.infoza.api.domain.ZIst;
import ru.infoza.api.repository.ZIstRepository;

@Service
public class ZIstService {

    private final ZIstRepository zIstRepository;

    @Autowired
    public ZIstService(ZIstRepository zIstRepository) {
        this.zIstRepository = zIstRepository;
    }

    public Optional<ZIst> getUserByVcUSR(String vcUSR) {
        return zIstRepository.findByVcUSR(vcUSR);
    }
}
