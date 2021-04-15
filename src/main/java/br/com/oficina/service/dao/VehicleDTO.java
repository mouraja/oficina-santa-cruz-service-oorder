/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.dao;

import lombok.Data;

/**
 *
 * @author moura
 */
@Data
public class VehicleDTO {
    private Long id;
    private String licensePlate;
    private String observations;
    private String model;
    private Boolean status;
}
