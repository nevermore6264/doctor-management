package com.daykemit.doctor.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * BaseController class
 *
 * @author HieuTT
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseRequest {
    private String createdBy;

    private String updatedBy;

    private Boolean isDeleted;

    private Date createdTime;

    private Date updatedTime;

    private Integer page;

    private Integer recordPage;

    private String sorting;

    private String uuid;
}
