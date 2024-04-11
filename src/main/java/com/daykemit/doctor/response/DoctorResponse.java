package com.daykemit.doctor.response;

import com.daykemit.doctor.utils.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * DoctorResponse for table "conversation"
 *
 * @author HieuTT121
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse extends BaseResponse {

    private int id;

    private String fullName;

    private int experienceYears;

    private String workLocation;

    private List<String> degrees;

    private List<String> specializations;
}
