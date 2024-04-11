/*
 * Copyright © 2021 VMO JSC. All rights reserved. Use is subject to license terms.
 *
 */
package com.daykemit.doctor.service;

import com.daykemit.doctor.request.DoctorRequest;
import com.daykemit.doctor.utils.Response;
import jakarta.servlet.http.HttpServletRequest;

/**
 * IDoctorService interface
 *
 * @author HieuTT121
 * @version 1.0
 */
public interface IDoctorService {

    /**
     * findById
     *
     * @param id Long
     * @return Response
     */
    Response findById(Long id);

    /**
     * findAll
     *
     * @param request DoctorRequest
     * @return Response
     */
    Response findAll(HttpServletRequest httpServletRequest, DoctorRequest request);

//    /**
//     * getPages
//     *
//     * @param request DoctorRequest
//     * @return Response
//     */
//    Response getPages(HttpServletRequest httpServletRequest, DoctorRequest request);
}
