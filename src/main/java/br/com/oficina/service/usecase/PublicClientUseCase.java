package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.PublicClientEntity;
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
public interface PublicClientUseCase {
    
    public List<PublicClientEntity> findAll();
    
    public Optional<PublicClientEntity> findById(Long id);

    public PublicClientEntity save(PublicClientEntity publicClient);

    public PublicClientEntity update(PublicClientEntity publicClient);

    public void deleteById(Long id);
    
}
