/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.dao;

import javax.persistence.Column;
import lombok.Data;

/**
 *
 * @author moura
 */
@Data
public class PublicClientAgentManagerDTO {
    private Long id;
    private String publicName;
    private String publicFantasyName;
    private String addressDelivery;
    private String addressBilling;
    private String primaryContact;
    private String primaryEmail;
    private String primaryPhoneNumber;
    private String primarySupportContact;
    private String observations;
    private Boolean status;
/*    
    private List<VehicleEntity> vehicles;
    private List<PublicClientAgentEntity> publicClientAgents;
    private List<ServiceOrderEntity> drivers;    
    private List<ServiceOrderEntity> controllers;
*/

}
