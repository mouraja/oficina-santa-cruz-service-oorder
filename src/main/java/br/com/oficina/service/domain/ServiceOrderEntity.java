/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import br.com.oficina.service.domain.ServiceOrderBiddingEntity;
import br.com.oficina.service.domain.PublicClientAgentEntity;
import br.com.oficina.utils.CommonAudityAttributeEntity;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author moura
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrderEntity extends CommonAudityAttributeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Integer serviceOrderYear;
    
    @Column(nullable = false)
    private VehicleEntity vehicle;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private PublicClientAgentEntity entryDriver;

    @Column(nullable = true)
    private PublicClientAgentEntity controller;

    @Column(nullable = true)
    private String controllerAprovedAt;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar entryVehicleDate;

    @Column(nullable = true)
    private String entryWaterLevel;

    @Column(nullable = true)
    private String entryOilLevel;

    @Column(nullable = true)
    private Integer entryOdometerKm;

    @Column(nullable = false)
    private String vehicleObservation;

    @OneToMany(
            targetEntity = ServiceOrderBiddingEntity.class,
            mappedBy = "serviceOrder",
            fetch = FetchType.EAGER)
    private List<ServiceOrderBiddingEntity> serviceOrderTasks;

    //@Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar expectedTimeDuration;

    //@Column(nullable = true)
    //private String signRevisor;
   
    //@Column(nullable = true)
    //private String signApprover;

    //@Column(nullable = true)
    //@Temporal(TemporalType.DATE)
    //private Calendar revisedDate;

    //@Column(nullable = true)
    //@Temporal(TemporalType.DATE)
    //private Calendar approvedDate;

    @Column(nullable = true)
    private ServiceOrderStatusEnum status;

    
}