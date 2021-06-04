package com.indonesian.region.controller;

import com.indonesian.region.model.Village;
import com.indonesian.region.payload.RegionResponse;
import com.indonesian.region.repository.VillageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class VillageController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VillageRepository villageRepository;

    @GetMapping("/villages/{district_id}")
    public ResponseEntity<?> findByDistrictId(@PathVariable("district_id") String districtId) {
        try {
            Map<String, Object> villages = new HashMap<>();
            villages.put("villages", convertToResponse(villageRepository.findByDistrictId(districtId)));
            return new ResponseEntity<>(villages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private List<RegionResponse> convertToResponse(List<Village> villages) {
        List<RegionResponse> responses = new ArrayList<>();
        for (Village village : villages) {
            RegionResponse response = modelMapper.map(village, RegionResponse.class);
            responses.add(response);
        }
        return responses;
    }
}
