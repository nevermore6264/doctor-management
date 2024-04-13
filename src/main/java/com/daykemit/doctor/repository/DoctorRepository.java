package com.daykemit.doctor.repository;

import com.daykemit.doctor.entity.DoctorEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * DoctorRepository interface
 *
 * @author HieuTT121
 * @version 1.0
 */
@Transactional
@Repository
public interface DoctorRepository {

    List<DoctorEntity> findAll();

    Optional<DoctorEntity> findById(Long id);

    List<DoctorEntity> getDoctors(
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );

    long countDoctors();

}
