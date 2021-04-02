/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.repository;

import br.com.oficina.service.domain.BiddingItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author moura
 */
@Repository
public interface BiddingItemRepository  
        extends CrudRepository<BiddingItemEntity, Long>  {
}
