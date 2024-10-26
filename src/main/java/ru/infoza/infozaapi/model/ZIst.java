package ru.infoza.infozaapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "z_ist")
@Data
public class ZIst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idIST", nullable = false, unique = true)
    private Integer idIST;

    @Column(name = "vcUSR", length = 32, unique = true)
    private String vcUSR;

    @Column(name = "vcFIO", length = 64)
    private String vcFIO;

    @Column(name = "vcORG", length = 200)
    private String vcORG;

    @Column(name = "dtWRK")
    private LocalDateTime dtWRK;

    @Column(name = "dtBBS")
    private LocalDateTime dtBBS;

    @Column(name = "dtCRE", nullable = false)
    private LocalDateTime dtCRE;

    @Column(name = "vcSOT", length = 128)
    private String vcSOT;

    @Column(name = "vcWRK", length = 128)
    private String vcWRK;

    @Column(name = "vcVNU", length = 128)
    private String vcVNU;

    @Column(name = "vcMAIL", length = 128)
    private String vcMAIL;

    @Column(name = "dtGB0")
    private LocalDateTime dtGB0;

    @Column(name = "dtGB1")
    private LocalDateTime dtGB1;

    @Column(name = "dtGB2")
    private LocalDateTime dtGB2;

    @Column(name = "dtGB3")
    private LocalDateTime dtGB3;

    @Column(name = "dtGB4")
    private LocalDateTime dtGB4;

    @Column(name = "dtMO")
    private LocalDateTime dtMO;

    @Column(name = "dtMT")
    private LocalDateTime dtMT;

    @Column(name = "dtBED")
    private LocalDateTime dtBED;

    @Column(name = "vcSTATUS", length = 255, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String vcSTATUS;

    @Column(name = "vcBIRTH", length = 5, columnDefinition = "VARCHAR(5) DEFAULT ''")
    private String vcBIRTH;

    @Column(name = "vcDOLGN", length = 255, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String vcDOLGN;

    @Column(name = "dtCBR")
    private LocalDateTime dtCBR;

}
