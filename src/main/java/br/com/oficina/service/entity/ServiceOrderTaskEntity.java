/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.entity;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author moura
 */
@Data
@Entity
public class ServiceOrderTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceOrderTaskId;
    
    @ManyToOne
    @JoinColumn(name="serviceOrderId")
    private ServiceOrderEntity serviceOrder;
    
    @Column(nullable = true)
    private String biddingId;
    
    @Column(nullable = false)
    private String taskDescription;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar expectedTimeDuration;    
}
