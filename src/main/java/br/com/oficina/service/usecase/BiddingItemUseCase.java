package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.BiddingItemEntity;
import java.util.List;
import java.util.Optional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moura
 */
public interface BiddingItemUseCase {
    
    public List<BiddingItemEntity> findAll();
    
    public List<BiddingItemEntity> findByBidding(Long biddingId);
    
    public Optional<BiddingItemEntity> findById(Long id);

    public BiddingItemEntity save(BiddingItemEntity biddingItem);

    public BiddingItemEntity update(BiddingItemEntity biddingItem);

    public void deleteById(Long id);
}
