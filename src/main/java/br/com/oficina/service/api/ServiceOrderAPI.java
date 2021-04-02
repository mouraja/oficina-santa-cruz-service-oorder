/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.api;

import br.com.oficina.service.domain.ServiceOrderEntity;
import br.com.oficina.service.usecase.ServiceOrderUseCase;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/api/services/order")
@Slf4j
@RequiredArgsConstructor
public class ServiceOrderAPI {
    
    private final ServiceOrderUseCase service;
    
    @GetMapping
    public ResponseEntity<List<ServiceOrderEntity>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ServiceOrderEntity> findById(@PathVariable long id){
        Optional<ServiceOrderEntity> serviceOrder = service.findById(id);
        if (!serviceOrder.isPresent()) {
            log.error("Service Order Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(serviceOrder.get());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ServiceOrderEntity serviceOrder){
        return ResponseEntity.ok(service.save(serviceOrder));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ServiceOrderEntity> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody ServiceOrderEntity serviceOrder){
        if (!service.findById(id).isPresent()) {
            log.error("Service Order Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.save(serviceOrder));
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity delete(
            @PathVariable("id") Long id) {
        log.debug(id.toString());
        if (!service.findById(id).isPresent()) {
            log.error("Service Order Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        service.deleteById(id);

        return ResponseEntity.ok().build();
    }
    
}
