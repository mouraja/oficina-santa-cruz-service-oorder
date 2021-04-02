/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.utils;

import java.util.Calendar;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author moura
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonAudityAttributeEntity {
    
    @CreatedDate
    protected Calendar createdOn;

    //@CreatedBy
    //protected UserMaster createdBy;

    @LastModifiedDate
    protected Calendar updatedOn;

    //@LastModifiedBy
    //protected UserMaster updatedBy;    
}
