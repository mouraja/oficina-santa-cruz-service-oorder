/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import br.com.oficina.utils.CommonAudityAttributeEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class BiddingEntity extends CommonAudityAttributeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String biddingDescription;
    
    @ManyToOne
    private PublicClientEntity publicInstitution;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar biddingInitialDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar biddingExpirateDate;
    
    @JsonBackReference
    @OneToMany(
        targetEntity = BiddingItemEntity.class,
        mappedBy = "bidding",
        fetch = FetchType.EAGER)
    private Set<BiddingItemEntity> biddingItems;
    
    private boolean status;
}
