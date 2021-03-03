/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.service;

import br.com.oficina.service.entity.ServiceOrderTaskEntity;
import br.com.oficina.service.repository.ServiceOrderTaskRepository;
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
public class ServiceOrderTaskService {

    private final ServiceOrderTaskRepository repository;


    public List<ServiceOrderTaskEntity> findAll() {
        return repository.findAll();
    }


    public Optional<ServiceOrderTaskEntity> findById(Long id){
        return repository.findById(id);
    }

    public ServiceOrderTaskEntity save(ServiceOrderTaskEntity serviceOrder){
        return repository.save(serviceOrder);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}