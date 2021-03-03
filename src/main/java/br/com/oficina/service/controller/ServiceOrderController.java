/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

/**
 *
 * @author moura
 */
@Controller
public class ServiceOrderController {
    @GetMapping("/")
    public String list(){
        return "ServiceOrders";
    }
}
