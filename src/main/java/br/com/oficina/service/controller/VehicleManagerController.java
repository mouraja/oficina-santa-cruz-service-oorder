/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.controller;

import br.com.oficina.service.dao.VehicleManagerDTO;
import br.com.oficina.service.domain.VehicleEntity;
import br.com.oficina.service.usecase.VehicleUseCase;
import java.util.List;
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
@RequestMapping("/api/manager/vehicle")
public class VehicleManagerController {

	@Autowired
	private ModelMapper modelMapper;

	private final VehicleUseCase vehicleUseCase;

	public VehicleManagerController(VehicleUseCase vehicleUseCase) {
		super();
		this.vehicleUseCase = vehicleUseCase;
	}

    /**
     *
     * @return
     */
    @GetMapping
	public List<VehicleManagerDTO> findAll() {
            return vehicleUseCase.findAll().stream().map(vehicle -> modelMapper.map(vehicle, VehicleManagerDTO.class))
				.collect(Collectors.toList());
	}

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
	public ResponseEntity<VehicleManagerDTO> findById(@PathVariable(name = "id") Long id) {
            //Optional<VehicleEntity> vehicle = vehicleUseCase.findById(id);
            //VehicleManagerDTO vehicleResponse = modelMapper.map(vehicle, VehicleManagerDTO.class);
            //return ResponseEntity.ok().body(vehicleResponse);
            
            return vehicleUseCase.findById(id)
                .map(record -> {
                    VehicleManagerDTO response = modelMapper.map(record, VehicleManagerDTO.class);
                    return ResponseEntity.ok().body(response);
                })
                .orElse(ResponseEntity.notFound().build());
	}
        

	@PostMapping
	public ResponseEntity<VehicleManagerDTO> create(@RequestBody VehicleManagerDTO vehicleDto) {

            // convert DTO to entity
            VehicleEntity request = modelMapper.map(vehicleDto, VehicleEntity.class);

            VehicleEntity record = vehicleUseCase.save(request);

            // convert entity to DTO
            VehicleManagerDTO response = modelMapper.map(record, VehicleManagerDTO.class);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// change the request for DTO
	// change the response for DTO
	@PutMapping("/{id}")
	public ResponseEntity<VehicleManagerDTO> update(@PathVariable long id, @RequestBody VehicleManagerDTO vehicleDto) {

            return vehicleUseCase.findById(id)
                .map(updating -> {
                    // convert DTO to Entity
                    VehicleEntity request = modelMapper.map(vehicleDto, VehicleEntity.class);
                    VehicleEntity record = vehicleUseCase.update(request);
                    // entity to DTO
                    VehicleManagerDTO response = modelMapper.map(record, VehicleManagerDTO.class);
                return ResponseEntity.ok().body(response); 
            }).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
            return vehicleUseCase.findById(id)
                .map(record -> {
                    vehicleUseCase.deleteById(id);
               return ResponseEntity.ok().build();
           }).orElse(ResponseEntity.notFound().build());
	}
        
}
