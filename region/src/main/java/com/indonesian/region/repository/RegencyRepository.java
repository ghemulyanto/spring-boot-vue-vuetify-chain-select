package com.indonesian.region.repository;

import com.indonesian.region.model.Regency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegencyRepository extends JpaRepository<Regency, String> {

    @Query("SELECT r FROM Regency r WHERE r.province.id = :provinceId")
    List<Regency> findByProvinceId(@Param("provinceId") String provinceId);
}
