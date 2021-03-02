/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.santacruz.api.service.controller;

import br.com.oficina.santacruz.api.service.repository.ServiceOrderRepository;
import br.com.oficina.santacruz.api.service.model.ServiceOrderEntity;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author moura
 */
@RestController
@RequestMapping("/services/order")
public class ServiceOrderController {
    @Autowired
    private ServiceOrderRepository repository;
    
    @GetMapping
    public List<ServiceOrderEntity> list() {
        return repository.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ServiceOrderEntity> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ServiceOrderEntity create(@RequestBody ServiceOrderEntity serviceOrder){
        return repository.save(serviceOrder);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ServiceOrderEntity> update(
            @PathVariable("id") long id,
            @RequestBody ServiceOrderEntity serviceOrder){
        return repository.findById(id)
                .map(record -> {
                    record.setVehicleModel(serviceOrder.getVehicleModel());
                    record.setEntryOdometer(serviceOrder.getEntryOdometer());
                    record.setEntryOilLevel(serviceOrder.getEntryOilLevel());
                    record.setEntryWaterLevel(serviceOrder.getEntryWaterLevel());
                    record.setReleasedMaintenanceBy(serviceOrder.getReleasedMaintenanceBy());
                    record.setRequestAutoPartDate(serviceOrder.getRequestAutoPartDate());
                    record.setServiceOrderTasks(serviceOrder.getServiceOrderTasks());
                    record.setServiceOrderExpectedTimeDuration(serviceOrder.getServiceOrderExpectedTimeDuration());
                    ServiceOrderEntity updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(
            @PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
}
