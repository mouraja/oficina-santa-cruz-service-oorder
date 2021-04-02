/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.PublicClientEntity;
import br.com.oficina.service.domain.ServiceOrderBiddingEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.oficina.service.repository.ServiceOrderBiddingRepository;
import java.util.ArrayList;

/**
 *
 * @author moura
 */
@Service
@RequiredArgsConstructor
public class ServiceOrderBiddingUseCaseImpl implements ServiceOrderBiddingUseCase {

    private final ServiceOrderBiddingRepository repository;


    public List<ServiceOrderBiddingEntity> findAll() {
        List<ServiceOrderBiddingEntity> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }


    public Optional<ServiceOrderBiddingEntity> findById(Long id){
        return repository.findById(id);
    }

    public ServiceOrderBiddingEntity save(ServiceOrderBiddingEntity serviceOrderBidding){
        return repository.save(serviceOrderBidding);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}