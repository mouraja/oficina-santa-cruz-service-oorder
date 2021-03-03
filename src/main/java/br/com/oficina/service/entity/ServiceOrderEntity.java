/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.entity;

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
import lombok.Data;

/**
 *
 * @author moura
 */
@Data
@Entity
public class ServiceOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceOrderId;
    
    @Column(nullable = false)
    private Integer serviceOrderIdYear;
    
    @Column(nullable = false)
    private String vehicleModel;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private String driverLeftVehicle;

    @Column(nullable = true)
    private String releasedMaintenanceBy;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar entryVehicleDate;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar requestAutoPartDate;

    @Column(nullable = true)
    private String entryWaterLevel;

    @Column(nullable = true)
    private String entryOilLevel;

    @Column(nullable = true)
    private Integer entryOdometerKm;

    @Column(nullable = false)
    private String vehicleObservation;

    @OneToMany(
            targetEntity = ServiceOrderTaskEntity.class,
            mappedBy = "serviceOrder",
            fetch = FetchType.EAGER)
    private List<ServiceOrderTaskEntity> serviceOrderTasks;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar expectedTimeDuration;
}