/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.ServiceOrderBiddingEntity;
import br.com.oficina.service.repository.ServiceOrderRepository;
import br.com.oficina.service.domain.ServiceOrderEntity;
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
public class ServiceOrderUseCaseImpl  {

    private final ServiceOrderRepository repository;
    
    public List<ServiceOrderEntity> findAll() {
        List<ServiceOrderEntity> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }
    
    public Optional<ServiceOrderEntity> findById(Long id){
        return repository.findById(id);
    }

    public ServiceOrderEntity save(ServiceOrderEntity serviceOrder){
        return repository.save(serviceOrder);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
