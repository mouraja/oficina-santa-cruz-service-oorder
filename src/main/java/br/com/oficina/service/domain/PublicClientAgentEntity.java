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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 *
 * @author moura
 */
@Data
@Entity
public class PublicClientAgentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publicClientAgentId;
    
    @ManyToOne
    @JoinColumn(name="publicClientId")
    private PublicClientEntity publicClient;

    @Column(nullable = false)
    private String publicAgentName;
    
    @Column(nullable = false)
    private String publicAgentRole;

    @Column(nullable = true)
    private String publicAgentPhonenumber;

    @Column(nullable = true)
    private String publicAgentEmail;

    @Column(nullable = true)
    private boolean status;

}
