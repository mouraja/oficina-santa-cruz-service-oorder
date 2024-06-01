/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.controller;

import br.com.oficina.service.dao.BiddingManagerDTO;
import br.com.oficina.service.domain.BiddingEntity;
import br.com.oficina.service.usecase.BiddingUseCase;
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
@RequestMapping("/api/manager/bidding")
public class BiddingManagerController {

	@Autowired
	private ModelMapper modelMapper;

	private final BiddingUseCase biddingUseCase;

	public BiddingManagerController(BiddingUseCase biddingUseCase) {
		super();
		this.biddingUseCase = biddingUseCase;
	}

    /**
     *
     * @return
     */
    @GetMapping
	public List<BiddingManagerDTO> findAll() {
            return biddingUseCase.findAll().stream().map(bidding -> modelMapper.map(bidding, BiddingManagerDTO.class))
				.collect(Collectors.toList());
	}

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
	public ResponseEntity<BiddingManagerDTO> findById(@PathVariable(name = "id") Long id) {
		Optional<BiddingEntity> bidding = biddingUseCase.findById(id);

		// convert entity to DTO
		BiddingManagerDTO biddingResponse = modelMapper.map(bidding, BiddingManagerDTO.class);

		return ResponseEntity.ok().body(biddingResponse);
	}

	@PostMapping
	public ResponseEntity<BiddingManagerDTO> create(@RequestBody BiddingManagerDTO biddingDto) {

		// convert DTO to entity
		BiddingEntity biddingRequest = modelMapper.map(biddingDto, BiddingEntity.class);

		BiddingEntity bidding = biddingUseCase.save(biddingRequest);

		// convert entity to DTO
		BiddingManagerDTO biddingResponse = modelMapper.map(bidding, BiddingManagerDTO.class);

		return new ResponseEntity<>(biddingResponse, HttpStatus.CREATED);
	}

	// change the request for DTO
	// change the response for DTO
	@PutMapping("/{id}")
	public ResponseEntity<BiddingManagerDTO> update(@PathVariable Long id, @RequestBody BiddingManagerDTO biddingDto) {

		// convert DTO to Entity
		BiddingEntity biddingRequest = modelMapper.map(biddingDto, BiddingEntity.class);

		BiddingEntity bidding = biddingUseCase.update(biddingRequest);

		// entity to DTO
		BiddingManagerDTO biddingResponse = modelMapper.map(bidding, BiddingManagerDTO.class);

		return ResponseEntity.ok().body(biddingResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
            return biddingUseCase.findById(id)
                .map(record -> {
                    biddingUseCase.deleteById(id);
               return ResponseEntity.ok().build();
           }).orElse(ResponseEntity.notFound().build());
	}
        
}
