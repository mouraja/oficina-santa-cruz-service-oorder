/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

import br.com.oficina.utils.CommonAudityAttributeEntity;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PublicClientEntity
    extends CommonAudityAttributeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String publicName;

    @Column(nullable = false)
    private String publicFantasyName;

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

    @Column(nullable = true)
    private String observation;
/*    
    @OneToMany(
            targetEntity = PublicClientAgentEntity.class,
            mappedBy = "publicClient",
            fetch = FetchType.EAGER)
    private List<PublicClientAgentEntity> publicClientAgents;
*/

}