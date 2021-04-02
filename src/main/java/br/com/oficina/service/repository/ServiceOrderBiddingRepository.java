/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.repository;

import br.com.oficina.service.domain.ServiceOrderBiddingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author moura
 */
public interface ServiceOrderBiddingRepository 
        extends JpaRepository<ServiceOrderBiddingEntity, Long>  {
    
}
