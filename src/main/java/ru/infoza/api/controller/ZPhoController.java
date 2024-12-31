package ru.infoza.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.infoza.api.dto.ZPhoInfoDTO;
import ru.infoza.api.service.ZPhoService;

@RestController
@RequestMapping("/phones")
public class ZPhoController {

    private final ZPhoService zPhoService;

    @Autowired
    public ZPhoController(ZPhoService zPhoService) {
        this.zPhoService = zPhoService;
    }

    @GetMapping("/{phone}")
    public List<ZPhoInfoDTO> getPersonalMessages(@PathVariable String phone) {
        return zPhoService.getPersonalMessages(phone);
    }
}
