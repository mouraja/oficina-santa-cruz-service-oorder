/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.enums;

/**
 *
 * @author moura
 */
public enum ServiceOrderStatusEnum {
    REQUEST_OPEN,
    REQUEST_PENDING_DOCUMENT,
    REQUEST_CANCELLED_BY_DRIVER_IN,
    REQUEST_CANCELLED_BY_WORKSHOP,
    REQUEST_APROVED,
    REQUEST_TO_BE_REFERRED,
    REQUEST_NOT_APROVED,
    REQUEST_IN_SERVICE,
    REQUEST_SERVICE_DONE,
    REQUEST_SERVICE_DONE_APROVED,
    REQUEST_SERVICE_NOT_APROVED,
    REQUEST_DONE,
    REQUEST_ACCEPTED_FOR_BILLING,
    REQUEST_PAYD
}
