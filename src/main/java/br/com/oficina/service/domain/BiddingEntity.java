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
    
    @Column
    private String description;
    
    @Column
    private String alias;    

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar initialDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar expirateDate;
    
    @Column
    private String observations;

    @Column
    private Boolean status;
    
    /*
    @ManyToOne
    private PublicClientEntity publicInstitution;
    */

/*    
    @JsonBackReference
    @OneToMany(
        targetEntity = BiddingItemEntity.class,
        mappedBy = "bidding",
        fetch = FetchType.EAGER)
    private Set<BiddingItemEntity> biddingItems;
        
    @JsonBackReference
    @OneToMany(
        targetEntity = ServiceOrderEntity.class,
        mappedBy = "id",
        fetch = FetchType.EAGER)
    private Set<ServiceOrderEntity> services;
  */

}
