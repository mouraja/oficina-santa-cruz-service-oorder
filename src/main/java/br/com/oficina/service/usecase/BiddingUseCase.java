package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.BiddingEntity;
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
public interface BiddingUseCase {
    
    public List<BiddingEntity> findAll();
    
    public Optional<BiddingEntity> findById(Long id);

    public BiddingEntity save(BiddingEntity bidding);

    public BiddingEntity update(BiddingEntity bidding);

    public void deleteById(Long id);
}
