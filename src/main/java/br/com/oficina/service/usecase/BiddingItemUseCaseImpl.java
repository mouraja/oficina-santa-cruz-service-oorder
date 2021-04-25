/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.BiddingItemEntity;
import br.com.oficina.service.repository.BiddingItemRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author moura
 */
@Service
@RequiredArgsConstructor
public class BiddingItemUseCaseImpl implements BiddingItemUseCase {
    
    private final BiddingItemRepository repository;
    
    @Override
    public List<BiddingItemEntity> findAll() {
        List<BiddingItemEntity> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }
    
    @Override
    public List<BiddingItemEntity> findByBidding(Long biddingId) {
        List<BiddingItemEntity> list = new ArrayList<>();
        repository.findAll().forEach(e -> {
                if (e.getBidding().getId().equals(biddingId)) {
                  list.add(e);
                }
        });
        return list;
    }
    
    @Override
    public Optional<BiddingItemEntity> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public BiddingItemEntity save(BiddingItemEntity biddingItem){
        return repository.save(biddingItem);
    }

    @Override
    public BiddingItemEntity update(BiddingItemEntity biddingItem){
        return repository.save(biddingItem);
    }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
