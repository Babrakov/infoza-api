package ru.infoza.infozaapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "z_msg")
@Data
public class ZMsg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMSG")
    private Integer idMSG;

    @Column(name = "inPART", nullable = false, columnDefinition = "int default 0")
    private Integer inPART;

    @Column(name = "dtDEL")
    private LocalDateTime dtDEL;

    @Column(name = "dtCRE")
    private LocalDateTime dtCRE;

    @Column(name = "inIST", nullable = false)
    private Integer inIST;

    @Column(name = "inTIP", nullable = false, columnDefinition = "int default 0")
    private Integer inTIP;

    @Column(name = "vcNAME", nullable = false, length = 100)
    private String vcNAME;

    @Column(name = "vcIP", length = 15, columnDefinition = "varchar(15) default ''")
    private String vcIP;

    @Column(name = "txMSG", columnDefinition = "text")
    private String txMSG;

    @Column(name = "inMID")
    private Integer inMID;

    @Column(name = "inTMP", nullable = false, columnDefinition = "int default 0")
    private Integer inTMP;

    @Column(name = "inIST_TO")
    private Integer inIstTo;

}
