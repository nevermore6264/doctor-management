package com.daykemit.doctor.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * BaseResponse class
 *
 * @author VMO
 * @version 1.0
 * @since 06/01/2022
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseResponse {

    private String createdBy;

    private String updatedBy;

    private Boolean isDeleted;

    private Date createdTime;

    private Date updatedTime;

    private String uuid;

}