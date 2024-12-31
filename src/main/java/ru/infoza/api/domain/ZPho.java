package ru.infoza.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "z_pho")
@Data
public class ZPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZP;

    private String vcPHO;
    private Integer inIST;
    private LocalDateTime dtCRE;
    private String vcIP;

}
