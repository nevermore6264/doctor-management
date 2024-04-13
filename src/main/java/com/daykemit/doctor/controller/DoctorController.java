package com.daykemit.doctor.controller;

import com.daykemit.doctor.request.DoctorRequest;
import com.daykemit.doctor.service.IDoctorService;
import com.daykemit.doctor.utils.BaseController;
import com.daykemit.doctor.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DoctorController class
 *
 * @author HieuTT
 * @version 1.0
 */
@RestController
@RequestMapping("/api/doctor")
public class DoctorController extends BaseController {

    @Autowired
    private IDoctorService service;

    /**
     * findById
     *
     * @param id Long
     * @return Response
     */
    @Operation(
            summary = "Conversation: API để xem chi tiết bác sĩ"
    )
    @GetMapping(path = "/detail/{id}")
    public Response findById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * findAll
     *
     * @param request DoctorRequest
     * @return Response
     */
    @Operation(
            summary = "Conversation: API để lấy danh sách bác sĩ không có phân trang"
    )
    @PostMapping(path = "/findAll")
    public Response findAll(HttpServletRequest httpServletRequest, @RequestBody DoctorRequest request) {
        return service.findAll(httpServletRequest, request);
    }

    /**
     * search
     *
     * @param request ConversationRequest
     * @return Response
     */
    @Operation(
            summary = "Conversation: API để lấy danh sách bác sĩ phân trang và lọc"
    )
    @PostMapping(path = "/search")
    public Response processSearch(HttpServletRequest httpServletRequest, @RequestBody DoctorRequest request) {
        return service.getPages(httpServletRequest, request);
    }

}
