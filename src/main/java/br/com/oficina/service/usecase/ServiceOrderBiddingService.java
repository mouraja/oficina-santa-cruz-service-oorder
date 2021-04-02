/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.ServiceOrderBiddingEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.oficina.service.repository.ServiceOrderBiddingRepository;

/**
 *
 * @author moura
 */
@Service
@RequiredArgsConstructor
public class ServiceOrderBiddingService {

    private final ServiceOrderBiddingRepository repository;


    public List<ServiceOrderBiddingEntity> findAll() {
        return repository.findAll();
    }


    public Optional<ServiceOrderBiddingEntity> findById(Long id){
        return repository.findById(id);
    }

    public ServiceOrderBiddingEntity save(ServiceOrderBiddingEntity serviceOrder){
        return repository.save(serviceOrder);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}