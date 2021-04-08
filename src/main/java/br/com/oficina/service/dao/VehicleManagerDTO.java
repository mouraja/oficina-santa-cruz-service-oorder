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
public class VehicleManagerDTO {   
    private Long id;
    private String manufactor;
    private String model;
    private String madeYear;
    private String modelYear;
    private String licensePlate;
    private PublicClientDTO clientOwner;
    private String observations;
    private boolean status;
/*
    private List<ServiceOrderEntity> serviceOrders;    
*/
}
