/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Integer item;
    
    @Column(nullable = false)
    private String itemCode;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String itemUnitService;

    @Column(nullable = false)
    private Integer itemAmountService;

    @Column(nullable = true)
    private Float unitValueService;

    @Column(nullable = true)
    private Float totalValueService;
        
    @Column(nullable = false)
    private boolean status;

/*    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="id")
    private BiddingEntity bidding;
*/
    
}
