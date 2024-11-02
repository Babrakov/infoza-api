package ru.infoza.infozaapi.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "lnzp")
@Data
public class Lnzp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLZP;

    private Integer idZZ;
    private Integer idZP;
    private Integer inTIP;
    private Integer inIST;
    private LocalDateTime dtCRE;
    private String vcIP;

}
