package ru.ifmo.mpi.magichospital.healer.domain.dao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import ru.ifmo.mpi.magichospital.healer.domain.dao.dict.RequestStatusDict;

@Entity
@Data
@Table(name = "disease_case")
public class Request {
	
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(targetEntity = Helper.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Helper helper;
        
    @ManyToOne(targetEntity = Healer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "healer_id")
    private Healer healer;
    
    @Column(name = "request_time")
    private LocalDateTime requestTime;
    
    @Column(name = "required_penta_help")
    private Boolean requiredPentaHelp;
 
    @Column(name = "description")
    private String description;  
    
    @ManyToOne(targetEntity = RequestStatusDict.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "status")
    private RequestStatusDict status;

}
