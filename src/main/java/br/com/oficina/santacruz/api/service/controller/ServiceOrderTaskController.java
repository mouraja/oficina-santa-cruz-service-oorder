/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.santacruz.api.service.controller;

import br.com.oficina.santacruz.api.service.model.ServiceOrderTaskEntity;
import br.com.oficina.santacruz.api.service.repository.ServiceOrderTaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author moura
 */
@RestController
@RequestMapping({"/services/order/{orderId}/tasks"})
public class ServiceOrderTaskController {

    @Autowired
    private ServiceOrderTaskRepository repository;

    @GetMapping
    public List<ServiceOrderTaskEntity> list() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ServiceOrderTaskEntity> findById(
            @PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ServiceOrderTaskEntity create(
            @RequestBody ServiceOrderTaskEntity serviceOrder){
        return repository.save(serviceOrder);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ServiceOrderTaskEntity> update(
            @PathVariable("id") long id,
            @RequestBody ServiceOrderTaskEntity serviceOrder){
        return repository.findById(id)
                .map(record -> {
                    record.setBiddingId(serviceOrder.getBiddingId());
                    record.setTaskDescription(serviceOrder.getTaskDescription());
                    record.setExpectedTimeDuration(serviceOrder.getExpectedTimeDuration());
                    ServiceOrderTaskEntity updated = repository.save(record);
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