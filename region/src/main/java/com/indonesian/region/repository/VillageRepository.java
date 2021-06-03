package com.indonesian.region.repository;

import com.indonesian.region.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, String> {

    @Query("SELECT v FROM Village v WHERE v.district.id = :districtId")
    List<Village> findByDistrictId(@Param("districtId") String districtId);
}
