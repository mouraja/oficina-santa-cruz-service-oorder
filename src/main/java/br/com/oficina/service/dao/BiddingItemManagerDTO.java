/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.dao;

import java.util.Calendar;
import lombok.Data;

/**
 *
 * @author moura
 */
@Data
public class BiddingItemManagerDTO {
    private Long id;
    private String description;
    private Calendar expectedWorkedHours;
}
