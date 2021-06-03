package com.indonesian.region.repository;

import com.indonesian.region.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {

    @Query(value = "SELECT p.id, p.name FROM provinces p", nativeQuery = true)
    List<Province> findIdAndNames();

}
