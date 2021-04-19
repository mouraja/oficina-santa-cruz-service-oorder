/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
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
    
    @Column(nullable = false)
    private boolean status;

/*    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="id")
    private BiddingEntity bidding;
*/
    
}
