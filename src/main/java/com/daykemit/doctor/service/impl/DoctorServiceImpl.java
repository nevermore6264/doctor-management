/*
 * Copyright © 2021 VMO JSC. All rights reserved. Use is subject to license terms.
 *
 */
package com.daykemit.doctor.service.impl;

import com.daykemit.doctor.entity.DoctorEntity;
import com.daykemit.doctor.repository.DoctorRepository;
import com.daykemit.doctor.request.DoctorRequest;
import com.daykemit.doctor.response.DoctorResponse;
import com.daykemit.doctor.service.IDoctorService;
import com.daykemit.doctor.utils.Constants;
import com.daykemit.doctor.utils.PageResultResponse;
import com.daykemit.doctor.utils.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DoctorServiceImpl class
 *
 * @author VMO
 * @version 1.0
 * @since 09/05/2023
 */
@Service
@Primary
public class DoctorServiceImpl implements IDoctorService {

    private DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    /**
     * findById
     *
     * @param id Long
     * @return Response
     */
    public Response findById(Long id) {
        DoctorEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            return Response.warning(Constants.RESPONSE_CODE.NO_RECORD, "Không tìm thấy bản ghi");
        }

        DoctorResponse response = mapToDTO(entity);
        return Response.success(
                Constants.RESPONSE_CODE.GET_DETAIL_SUCCESS,
                "Lấy chi tiết bản ghi thành công"
        ).withData(response);
    }

    /**
     * getDatatables
     *
     * @param request DoctorRequest
     * @return Response
     */
    public Response findAll(HttpServletRequest httpServletRequest, DoctorRequest request) {
        List<DoctorEntity> entities = repository.findAll();
        return Response.success(
                Constants.RESPONSE_CODE.SUCCESS,
                "Tìm kiếm dữ liệu thành công"
        ).withData(entities);
    }


    @Override
    public Response getPages(HttpServletRequest httpServletRequest, DoctorRequest request) {
        Integer pageIndex = request.getPageIndex();
        Integer pageSize = request.getPageSize();
        int offset = (pageIndex - 1) * pageSize;

        List<DoctorEntity> doctorEntities = repository.getDoctors(offset, pageSize);
        List<DoctorResponse> doctorResponses = doctorEntities
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        long totalElements = repository.countDoctors();
        int totalPages = (int) Math.ceil((double) totalElements / pageSize);

        // Prepare PageResultResponse
        PageResultResponse<DoctorResponse> resultResponse = new PageResultResponse<>();
        resultResponse.setContent(doctorResponses);
        resultResponse.setPageIndex(pageIndex);
        resultResponse.setPageSize(pageSize);
        resultResponse.setTotalPages(totalPages);
        resultResponse.setTotalElements(totalElements);
        resultResponse.setLast(pageIndex == totalPages);

        return Response.success(Constants.RESPONSE_CODE.SUCCESS, "Tìm kiếm dữ liệu thành công").withData(resultResponse);
    }

    /**
     * convert entity into response
     *
     * @param entity DoctorEntity
     * @return DoctorResponse
     */
    private DoctorResponse mapToDTO(DoctorEntity entity) {
        DoctorResponse response = new DoctorResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
