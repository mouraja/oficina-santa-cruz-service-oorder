/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.ServiceOrderEntity;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author moura
 */
public interface ServiceOrderUseCase  {

    public List<ServiceOrderEntity> findAll();
    
    public Optional<ServiceOrderEntity> findById(Long id);

    public ServiceOrderEntity save(ServiceOrderEntity serviceOrder);

    public ServiceOrderEntity update(ServiceOrderEntity serviceOrder);

    public void deleteById(Long id);
    
}
