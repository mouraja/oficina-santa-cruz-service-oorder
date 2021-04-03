package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.PublicClientAgentEntity;
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
public interface PublicClientAgentUseCase {
    
    public List<PublicClientAgentEntity> findAll();
    
    public Optional<PublicClientAgentEntity> findById(Long id);

    public PublicClientAgentEntity save(PublicClientAgentEntity serviceOrder);

    public PublicClientAgentEntity update(PublicClientAgentEntity serviceOrder);

    public void deleteById(Long id);
}
