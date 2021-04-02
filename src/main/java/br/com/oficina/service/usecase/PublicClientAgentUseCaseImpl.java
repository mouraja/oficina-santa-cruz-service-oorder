/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.PublicClientAgentEntity;
import br.com.oficina.service.repository.PublicClientAgentRepository;
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
public class PublicClientAgentUseCaseImpl implements PublicClientAgentUseCase {
    
    private final PublicClientAgentRepository repository;
    
    @Override
    public List<PublicClientAgentEntity> findAll() {
        List<PublicClientAgentEntity> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }
    
    @Override
    public Optional<PublicClientAgentEntity> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public PublicClientAgentEntity save(PublicClientAgentEntity serviceOrder){
        return repository.save(serviceOrder);
    }

    @Override
    public PublicClientAgentEntity update(PublicClientAgentEntity serviceOrder){
        return repository.save(serviceOrder);
    }
    
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
