/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.VehicleEntity;
import br.com.oficina.service.repository.VehicleRepository;
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
public class VehicleUseCaseImpl implements VehicleUseCase {
    
    private final VehicleRepository repository;
    
    @Override
    public List<VehicleEntity> findAll() {
        List<VehicleEntity> list = new ArrayList<>();
        repository.findAll().forEach(e -> list.add(e));
        return list;
    }
    
    @Override
    public Optional<VehicleEntity> findById(Long id){
        return repository.findById(id);
    }

    @Override
    public VehicleEntity save(VehicleEntity vehicle){
        return repository.save(vehicle);
    }

    @Override
    public VehicleEntity update(VehicleEntity vehicle){
        return repository.save(vehicle);
    }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
