/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.controller;

import br.com.oficina.service.dao.PublicClientDTO;
import br.com.oficina.service.domain.PublicClientEntity;
import br.com.oficina.service.usecase.PublicClientUseCase;
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
@RequestMapping("/api/manager/client/public")
public class PublicClientManagerController {

    @Autowired
    private ModelMapper modelMapper;
    private final PublicClientUseCase publicClientUseCase;

    public PublicClientManagerController(PublicClientUseCase publicClientUseCase) {
        super();
        this.publicClientUseCase = publicClientUseCase;
    }

    /**
     *
     * @return
     */
    @GetMapping
    public List<PublicClientDTO> findAll() {
        return publicClientUseCase.findAll().stream().map(publicClient -> modelMapper.map(publicClient, PublicClientDTO.class))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PublicClientDTO> findById(@PathVariable(name = "id") Long id) {
        Optional<PublicClientEntity> publicClient = publicClientUseCase.findById(id);
        // convert entity to DTO
        PublicClientDTO publicClientResponse = modelMapper.map(publicClient, PublicClientDTO.class);
        return ResponseEntity.ok().body(publicClientResponse);
    }

    @PostMapping
    public ResponseEntity<PublicClientDTO> create(@RequestBody PublicClientDTO publicClientDto) {
        // convert DTO to entity
        PublicClientEntity publicClientRequest = modelMapper.map(publicClientDto, PublicClientEntity.class);
        PublicClientEntity publicClient = publicClientUseCase.save(publicClientRequest);
        // convert entity to DTO
        PublicClientDTO publicClientResponse = modelMapper.map(publicClient, PublicClientDTO.class);
        return new ResponseEntity<>(publicClientResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicClientDTO> update(@PathVariable long id, @RequestBody PublicClientDTO publicClientDto) {
        // convert DTO to Entity
        PublicClientEntity publicClientRequest = modelMapper.map(publicClientDto, PublicClientEntity.class);
        PublicClientEntity publicClient = publicClientUseCase.update(publicClientRequest);
        // entity to DTO
        PublicClientDTO publicClientResponse = modelMapper.map(publicClient, PublicClientDTO.class);
        return ResponseEntity.ok().body(publicClientResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return publicClientUseCase.findById(id)
            .map(record -> {
                publicClientUseCase.deleteById(id);
                return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
