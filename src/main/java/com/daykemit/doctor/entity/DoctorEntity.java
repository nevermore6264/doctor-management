package com.daykemit.doctor.entity;

import com.daykemit.doctor.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Doctor class
 *
 * @author HieuTT121
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorEntity extends BaseEntity {

    private Long id;

    private Long accountId;

    private String uuid;

    private String title;

}
