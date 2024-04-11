package com.daykemit.doctor.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * BaseEntity
 *
 * @author VMO
 * @version 1.0
 */
@Setter
@Getter
@NoArgsConstructor
public class BaseEntity {
    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

    private Boolean isDeleted;

    private String uuid;
}
