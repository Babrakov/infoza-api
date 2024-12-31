package ru.infoza.api.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.infoza.api.domain.ZMsg;
import ru.infoza.api.service.ZMsgService;

@RestController
@RequestMapping("/messages")
public class ZMsgController {

    private final ZMsgService zMsgService;

    public ZMsgController(ZMsgService zMsgService) {
        this.zMsgService = zMsgService;
    }

    @GetMapping("/all-vacancies")
    public List<ZMsg> getAllVacancies() {
        return zMsgService.getAllVacancyMessages();
    }

    @GetMapping("/vacancies")
    public Page<ZMsg> getVacancies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return zMsgService.getVacancyMessages(
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "dtCRE"))
        );
    }

    @GetMapping("/personal")
    public List<ZMsg> getPersonalMessages() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return zMsgService.getPersonalMessages(authentication);
    }

}
