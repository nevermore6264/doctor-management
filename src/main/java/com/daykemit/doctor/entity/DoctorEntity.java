package com.daykemit.doctor.entity;

import com.daykemit.doctor.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    private int id;

    private String fullName;

    private int experienceYears;

    private String workLocation;

    private List<String> degrees;

    private List<String> specializations;

}
