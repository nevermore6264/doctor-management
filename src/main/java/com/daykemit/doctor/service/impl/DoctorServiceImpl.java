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
import com.daykemit.doctor.utils.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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

//
//    @Override
//    public Response getPages(HttpServletRequest httpServletRequest, DoctorRequest request) {
//        // Check page size and page index and set default value.
//        Integer pageIndex = request.getPageIndex();
//        Integer pageSize = request.getPageSize();
//        if (validateBeforeGetPages(pageIndex, pageIndex) != null) {
//            return validateBeforeGetPages(pageIndex, pageIndex);
//        }
//        // Get list product detail info
//        String sortBy = "createdTime";
//        String sortDir = Constants.PAGING_CONFIG.DEFAULT_SORT_DIRECTION;
//
//        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
//                : Sort.by(sortBy).descending();
//
//        String authorizationHeader = httpServletRequest.getHeader("Authorization");
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            String jwt = authorizationHeader.substring(7).trim();
//            AccountEntity account = accountRepository.findByEmail(Mixin.getEmailFromJwt(jwt, secretKey)).orElse(null);
//            if (account != null) {
//                Specification<DoctorEntity> specification = (root, query, builder) -> {
//                    List<Predicate> predicates = new ArrayList<>();
//
//                    // Add filter criteria based on non-null fields in the request
//                    if (account.getId() != null) {
//                        predicates.add(builder.equal(root.get("accountId"), account.getId()));
//                    }
//                    return builder.and(predicates.toArray(new Predicate[0]));
//                };
//
//                // create Pageable instance
//                Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort);
//
//                Page<DoctorEntity> conversationEntities = repository.findAll(specification, pageable);
//                // get content for page object
//                List<DoctorEntity> conversationEntitiesContent = conversationEntities.getContent();
//
//                List<DoctorResponse> content = conversationEntitiesContent.stream().map(this::mapToDTO).collect(Collectors.toList());
//
//                // Prepare data for response
//                PageResultResponse<DoctorResponse> resultResponse = new PageResultResponse<>();
//                resultResponse.setContent(content);
//                resultResponse.setPageIndex(pageIndex);
//                resultResponse.setPageSize(pageSize);
//                resultResponse.setTotalPages(conversationEntities.getTotalPages());
//                resultResponse.setTotalElements(conversationEntities.getTotalElements());
//                resultResponse.setLast(conversationEntities.isLast());
//
//                return Response.success(Constants.RESPONSE_CODE.SUCCESS, "Tìm kiếm dữ liệu thành công").withData(resultResponse);
//            }
//        }
//        return Response.warning(Constants.RESPONSE_CODE.WARNING, "Không tìm thấy email trong hệ thống");
//    }

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
