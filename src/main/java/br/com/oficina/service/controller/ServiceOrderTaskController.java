/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author moura
 */
@Controller
public class ServiceOrderTaskController {
    @GetMapping("/tasks")
    public String list(){
        return "ServiceOrderTasks";
    }
}