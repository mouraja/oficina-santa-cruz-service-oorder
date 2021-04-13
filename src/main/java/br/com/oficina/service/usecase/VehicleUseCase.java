package br.com.oficina.service.usecase;

import br.com.oficina.service.domain.VehicleEntity;
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
public interface VehicleUseCase {
    
    public List<VehicleEntity> findAll();
    
    public Optional<VehicleEntity> findById(Long id);

    public VehicleEntity save(VehicleEntity vehicle);

    public VehicleEntity update(VehicleEntity vehicle);

    public void deleteById(Long id);
}
