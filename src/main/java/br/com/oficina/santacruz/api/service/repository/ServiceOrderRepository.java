/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.santacruz.api.service.repository;

import br.com.oficina.santacruz.api.service.model.ServiceOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author moura
 */
@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrderEntity, Long> {
    
}
