/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class VehicleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    @Column(nullable = false)
    private String licensePlate;
    
    @Column(nullable = false)
    private String clientOwner;
    
    @Column(nullable = true)
    private String observations;
    
    @Column(nullable = true)
    private String manufactor;
    
    @Column(nullable = false)
    private String model;
    
    @Column(nullable = true)
    private String madeYear;
    
    @Column(nullable = true)
    private String modelYear;
    
    @Column(nullable = true)
    private boolean status;

    @OneToMany(
            targetEntity = ServiceOrderEntity.class,
            mappedBy = "vehicle",
            fetch = FetchType.EAGER)
    private List<ServiceOrderEntity> serviceOrders;    

}
