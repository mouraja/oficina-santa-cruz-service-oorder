/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.utils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author moura
 */
public abstract class LegalPersonAbstratic {
    
    @Column(nullable = false)
    private String name;
 
    @Column(nullable = false)
    private String fantasyName;

    @Column(nullable = true)
    private String addressDelivery;

    @Column(nullable = true)
    private String addressBilling;

    @Column(nullable = true)
    private String primaryContact;

    @Column(nullable = true)
    private String primaryEmail;

    @Column(nullable = true)
    private String primaryPhoneNumber;

    @Column(nullable = true)
    private String primarySupportContact;
}
