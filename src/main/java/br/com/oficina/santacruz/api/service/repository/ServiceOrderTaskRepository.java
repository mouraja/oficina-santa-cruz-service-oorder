/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.santacruz.api.service.repository;

import br.com.oficina.santacruz.api.service.model.ServiceOrderTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author moura
 */
public interface ServiceOrderTaskRepository extends JpaRepository<ServiceOrderTaskEntity, Long>  {
    
}
