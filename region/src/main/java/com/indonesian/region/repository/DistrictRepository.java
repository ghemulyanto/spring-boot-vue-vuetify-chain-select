package com.indonesian.region.repository;

import com.indonesian.region.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {

    @Query("SELECT d FROM District d WHERE d.regency.id = :regencyId")
    List<District> findByRegencyId(@Param("regencyId") String regencyId);
}
