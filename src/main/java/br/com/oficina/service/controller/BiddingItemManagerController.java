/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.controller;

import br.com.oficina.service.dao.BiddingItemManagerDTO;
import br.com.oficina.service.domain.BiddingItemEntity;
import br.com.oficina.service.usecase.BiddingItemUseCase;
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
@RequestMapping("/api/manager/biddingItem")
public class BiddingItemManagerController {

	@Autowired
	private ModelMapper modelMapper;

	private final BiddingItemUseCase biddingItemItemUseCase;

	public BiddingItemManagerController(BiddingItemUseCase biddingItemItemUseCase) {
		super();
		this.biddingItemItemUseCase = biddingItemItemUseCase;
	}

    /**
     *
     * @return
     */
    @GetMapping
	public List<BiddingItemManagerDTO> findAll() {
            return biddingItemItemUseCase.findAll().stream().map(biddingItem -> modelMapper.map(biddingItem, BiddingItemManagerDTO.class))
				.collect(Collectors.toList());
	}

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
	public ResponseEntity<BiddingItemManagerDTO> findById(@PathVariable(name = "id") Long id) {
		Optional<BiddingItemEntity> biddingItem = biddingItemItemUseCase.findById(id);

		// convert entity to DTO
		BiddingItemManagerDTO biddingItemResponse = modelMapper.map(biddingItem, BiddingItemManagerDTO.class);

		return ResponseEntity.ok().body(biddingItemResponse);
	}

	@PostMapping
	public ResponseEntity<BiddingItemManagerDTO> create(@RequestBody BiddingItemManagerDTO biddingItemDto) {

		// convert DTO to entity
		BiddingItemEntity biddingItemRequest = modelMapper.map(biddingItemDto, BiddingItemEntity.class);

		BiddingItemEntity biddingItem = biddingItemItemUseCase.save(biddingItemRequest);

		// convert entity to DTO
		BiddingItemManagerDTO biddingItemResponse = modelMapper.map(biddingItem, BiddingItemManagerDTO.class);

		return new ResponseEntity<>(biddingItemResponse, HttpStatus.CREATED);
	}

	// change the request for DTO
	// change the response for DTO
	@PutMapping("/{id}")
	public ResponseEntity<BiddingItemManagerDTO> update(@PathVariable Long id, @RequestBody BiddingItemManagerDTO biddingItemDto) {

		// convert DTO to Entity
		BiddingItemEntity biddingItemRequest = modelMapper.map(biddingItemDto, BiddingItemEntity.class);

		BiddingItemEntity biddingItem = biddingItemItemUseCase.update(biddingItemRequest);

		// entity to DTO
		BiddingItemManagerDTO biddingItemResponse = modelMapper.map(biddingItem, BiddingItemManagerDTO.class);

		return ResponseEntity.ok().body(biddingItemResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
            return biddingItemItemUseCase.findById(id)
                .map(record -> {
                    biddingItemItemUseCase.deleteById(id);
               return ResponseEntity.ok().build();
           }).orElse(ResponseEntity.notFound().build());
	}
        
}
