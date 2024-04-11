package com.daykemit.doctor.response;

import com.daykemit.doctor.utils.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private Long id;

    private String title;

}
