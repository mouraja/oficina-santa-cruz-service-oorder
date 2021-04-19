/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.BiddingEntity;
import br.com.oficina.service.repository.BiddingRepository;
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
public class BiddingUseCaseImpl implements BiddingUseCase {
    
    private final BiddingRepository repository;
    
    @Override
    public List<BiddingEntity> findAll() {
        List<BiddingEntity> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }
    
    @Override
    public Optional<BiddingEntity> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public BiddingEntity save(BiddingEntity bidding){
        return repository.save(bidding);
    }

    @Override
    public BiddingEntity update(BiddingEntity bidding){
        return repository.save(bidding);
    }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
