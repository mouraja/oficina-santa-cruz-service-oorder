/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.dao;

import java.util.Calendar;
import java.util.List;
import lombok.Data;

/**
 *
 * @author moura
 */
@Data
public class BiddingManagerDTO {   
    private Long id;
    private String alias;
    private String description;
    private PublicClientDTO publicInstitution;
    private Calendar initialDate;
    private Calendar expirateDate;
    private String observations;
    private Boolean status;
    private List<BiddingItemDTO> biddingItems;
    /*
    private Set<ServiceOrderEntity> services;
    */
}
