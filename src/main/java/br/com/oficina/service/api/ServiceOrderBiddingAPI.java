/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.api;

import br.com.oficina.service.domain.ServiceOrderBiddingEntity;
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
import br.com.oficina.service.repository.ServiceOrderBiddingRepository;

/**
 *
 * @author moura
 */
@RestController
@RequestMapping({"/services/order/{orderId}/tasks"})
public class ServiceOrderBiddingAPI {

    @Autowired
    private ServiceOrderBiddingRepository repository;

    @GetMapping
    public List<ServiceOrderBiddingEntity> list() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ServiceOrderBiddingEntity> findById(
            @PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ServiceOrderBiddingEntity create(
            @RequestBody ServiceOrderBiddingEntity serviceOrder){
        return repository.save(serviceOrder);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ServiceOrderBiddingEntity> update(
            @PathVariable("id") long id,
            @RequestBody ServiceOrderBiddingEntity serviceOrder){
        return repository.findById(id)
                .map(record -> {
                    record.setBidding(serviceOrder.getBidding());
                    record.setTaskDescription(serviceOrder.getTaskDescription());
                    record.setExpectedTimeDuration(serviceOrder.getExpectedTimeDuration());
                    record.setRequestedAutoPart(serviceOrder.getRequestedAutoPart());
                    record.setAuthorizerTaskDone(serviceOrder.getAuthorizerTaskDone());
                    record.setAuthorizerTaskTodo(serviceOrder.getAuthorizerTaskTodo());
                    record.setServiceOrder(serviceOrder.getServiceOrder());
                    record.setStatus(serviceOrder.getStatus());
                    ServiceOrderBiddingEntity updated = repository.save(record);
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