package ru.infoza.infozaapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "s_usr")
@Data
public class SUsr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUSR", nullable = false, unique = true)
    private Integer idUSR;

    @Column(name = "vcUSR", nullable = false, length = 16)
    private String vcUSR;

    @Column(name = "vcLNA", nullable = false, length = 32)
    private String vcLNA;

    @Column(name = "vcFNA", nullable = false, length = 32)
    private String vcFNA;

    @Column(name = "vcMNA", length = 32)
    private String vcMNA;

    @Column(name = "inTIP", nullable = false)
    private Integer inTIP;

    @Column(name = "inGRP", nullable = false)
    private Integer inGRP;

    @Column(name = "vcSITY", length = 32)
    private String vcSITY;

    @Column(name = "vcORG", length = 128)
    private String vcORG;

    @Column(name = "vcIP", length = 32)
    private String vcIP;

    @Column(name = "inLOG", nullable = false)
    private Integer inLOG;

    @Column(name = "vcHOST", length = 255)
    private String vcHOST;

    @Column(name = "inLST", nullable = false)
    private Integer inLST;
}
