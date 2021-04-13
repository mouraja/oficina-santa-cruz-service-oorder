/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.PublicClientEntity;
import br.com.oficina.service.repository.PublicClientRepository;
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
public class PublicClientUseCaseImpl implements PublicClientUseCase {
    
    private final PublicClientRepository repository;
    
    @Override
    public List<PublicClientEntity> findAll() {
        List<PublicClientEntity> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }
    
    @Override
    public Optional<PublicClientEntity> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public PublicClientEntity save(PublicClientEntity serviceOrder){
        return repository.save(serviceOrder);
    }

    @Override
    public PublicClientEntity update(PublicClientEntity serviceOrder){
        return repository.save(serviceOrder);
    }
    
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
