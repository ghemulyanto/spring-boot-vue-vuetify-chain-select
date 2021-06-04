package com.indonesian.region.controller;

import com.indonesian.region.model.District;
import com.indonesian.region.payload.RegionResponse;
import com.indonesian.region.repository.DistrictRepository;
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
public class DistrictController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DistrictRepository districtRepository;

    @GetMapping("/districts/{regency_id}")
    public ResponseEntity<Map<String, Object>> findByRegencyId(@PathVariable("regency_id") String regencyId) {
        try {
            Map<String, Object> districts = new HashMap<>();
            districts.put("districts", convertToResponse(districtRepository.findByRegencyId(regencyId)));
            return new ResponseEntity<>(districts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private List<RegionResponse> convertToResponse(List<District> districts) {
        List<RegionResponse> responses = new ArrayList<>();
        for (District district : districts) {
            RegionResponse response = modelMapper.map(district, RegionResponse.class);
            responses.add(response);
        }
        return responses;
    }
}
