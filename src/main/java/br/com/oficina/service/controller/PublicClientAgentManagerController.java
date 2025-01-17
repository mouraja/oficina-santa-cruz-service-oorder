/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.controller;

import br.com.oficina.service.dao.PublicClientAgentManagerDTO;
import br.com.oficina.service.domain.PublicClientAgentEntity;
import br.com.oficina.service.usecase.PublicClientAgentUseCase;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/manager/client/public/agent")
public class PublicClientAgentManagerController {

    @Autowired
    private ModelMapper modelMapper;
    private final PublicClientAgentUseCase publicClientAgentUseCase;

    public PublicClientAgentManagerController(PublicClientAgentUseCase publicClientAgentUseCase) {
        super();
        this.publicClientAgentUseCase = publicClientAgentUseCase;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<PublicClientAgentManagerDTO> findAll() {
        return publicClientAgentUseCase.findAll().stream().map(publicClientAgent -> modelMapper.map(publicClientAgent, PublicClientAgentManagerDTO.class))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PublicClientAgentManagerDTO> findById(@PathVariable(name = "id") Long id) {
        Optional<PublicClientAgentEntity> publicClientAgent = publicClientAgentUseCase.findById(id);
        // convert entity to DTO
        PublicClientAgentManagerDTO publicClientResponse = modelMapper.map(publicClientAgent, PublicClientAgentManagerDTO.class);
        return ResponseEntity.ok().body(publicClientResponse);
    }

    @PostMapping
    public ResponseEntity<PublicClientAgentManagerDTO> create(@RequestBody PublicClientAgentManagerDTO publicClientAgentDTO) {
        // convert DTO to entity
        PublicClientAgentEntity publicClientAgentRequest = modelMapper.map(publicClientAgentDTO, PublicClientAgentEntity.class);
        PublicClientAgentEntity publicClientAgent = publicClientAgentUseCase.save(publicClientAgentRequest);
        // convert entity to DTO
        PublicClientAgentManagerDTO publicClientResponse = modelMapper.map(publicClientAgent, PublicClientAgentManagerDTO.class);
        return new ResponseEntity<>(publicClientResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicClientAgentManagerDTO> update(@PathVariable long id, @RequestBody PublicClientAgentManagerDTO publicClientAgentDTO) {
        // convert DTO to Entity
        PublicClientAgentEntity publicClientAgentRequest = modelMapper.map(publicClientAgentDTO, PublicClientAgentEntity.class);
        PublicClientAgentEntity publicClientAgent = publicClientAgentUseCase.update(publicClientAgentRequest);
        // entity to DTO
        PublicClientAgentManagerDTO publicClientResponse = modelMapper.map(publicClientAgent, PublicClientAgentManagerDTO.class);
        return ResponseEntity.ok().body(publicClientResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return publicClientAgentUseCase.findById(id)
            .map(record -> {
                publicClientAgentUseCase.deleteById(id);
                return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
