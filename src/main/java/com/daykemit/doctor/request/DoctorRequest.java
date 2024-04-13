package com.daykemit.doctor.request;

import com.daykemit.doctor.utils.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DoctorRequest class
 *
 * @author HieuTT121
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequest extends BaseRequest {

    private Long id;

    private Integer pageIndex;

    private Integer pageSize;

}
