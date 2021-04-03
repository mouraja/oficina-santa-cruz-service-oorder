/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import br.com.oficina.utils.CommonAudityAttributeEntity;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

/*
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="idVehicle", referencedColumnName="id")
    private VehicleEntity vehicle;
*/
    
    @Column(nullable = false)
    private String licensePlate;

/*
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="idDriver", referencedColumnName="id")
    private PublicClientAgentEntity entryDriver;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="idController", referencedColumnName="id")
    private PublicClientAgentEntity controller;
*/
    
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

/*
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="idBidding", referencedColumnName="id")
    private BiddingEntity bidding;
    
    @JsonManagedReference
    @OneToMany(
            targetEntity = ServiceOrderBiddingEntity.class,
            mappedBy = "serviceOrder",
            fetch = FetchType.EAGER)
    private Set<ServiceOrderBiddingEntity> biddingItems;
*/
    
    //@Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar expectedTimeDuration;

    @Column(nullable = true)
    private ServiceOrderStatusEnum status;

}