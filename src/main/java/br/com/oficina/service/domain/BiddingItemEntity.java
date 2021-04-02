/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import br.com.oficina.service.domain.BiddingEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author moura
 */
@Data
@Entity
public class BiddingItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar expectedWorkedHours;
    
    @Column(nullable = true)
    private Float valuePayedByHour;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="id")
    private BiddingEntity bidding;
    
    @Column(nullable = false)
    private boolean status;
    
}