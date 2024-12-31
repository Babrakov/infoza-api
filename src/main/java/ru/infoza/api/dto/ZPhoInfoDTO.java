package ru.infoza.api.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ZPhoInfoDTO {

    private LocalDateTime dtCRE;
    private Integer inTIP;
    private String vcORG;

    public ZPhoInfoDTO(LocalDateTime dtCRE, Integer inTIP, String vcORG) {
        this.dtCRE = dtCRE;
        this.inTIP = inTIP;
        this.vcORG = vcORG;
    }

}
