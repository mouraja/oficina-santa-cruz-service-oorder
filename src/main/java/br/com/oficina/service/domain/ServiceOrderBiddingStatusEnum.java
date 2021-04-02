/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service.domain;

/**
 *
 * @author moura
 */
public enum ServiceOrderBiddingStatusEnum {
    TASK_TODO_OPEN,
    TASK_TODO_AUTHORIZED,
    TASK_TODO_NOT_AUTHORIZED,
    TASK_TODO_CANCELLED,
    TASK_IN_SERVICE,
    TASK_IN_SERVICE_PENDING_PART,
    TASK_IN_SERVICE_PENDING_TOOL,
    TASK_IN_SERVICE_PENDING_PARTNER,
    TASK_IN_SERVICE_PENDING_INSUMES,
    TASK_IN_SERVICE_DONE,
    TASK_IN_SERVICE_DONE_ACCEPTED,
    TASK_IN_SERVICE_DONE_REJECTED,
    TASK_BILLING_AUTHORIZED,
    TASK_BILLING_REQUIREMENT,
    TASK_BILLING_PAYED
}
