/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import br.com.oficina.service.domain.PublicOrderRequestAutoPart;
import br.com.oficina.service.domain.BiddingStatusEnum;
import br.com.oficina.service.domain.PublicClientAgentEntity;
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
public class ServiceOrderBiddingEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceOrderBiddingId;
    
    @ManyToOne
    @JoinColumn(name="serviceOrderId")
    private ServiceOrderEntity serviceOrder;
    
    @Column(nullable = true)
    private BiddingStatusEnum bidding;
    
    @Column(nullable = false)
    private String taskDescription;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar expectedTimeDuration;
            
    @Column(nullable = true)
    private PublicClientAgentEntity authorizerTaskTodo;
            
    @Column(nullable = true)
    private PublicClientAgentEntity authorizerTaskDone;
    
    @Column(nullable = true)
    private PublicOrderRequestAutoPart requestedAutoPart;
    
    @Column(nullable = true)
    private ServiceOrderBiddingStatusEnum status;
    
}
