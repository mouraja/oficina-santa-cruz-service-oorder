/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.ServiceOrderBiddingEntity;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author moura
 */
public interface ServiceOrderBiddingUseCase {
    public List<ServiceOrderBiddingEntity> findAll();
    public Optional<ServiceOrderBiddingEntity> findById(Long id);
    public ServiceOrderBiddingEntity save(ServiceOrderBiddingEntity serviceOrderBidding);
    public void deleteById(Long id);
}