package com.indonesian.region.controller;

import com.indonesian.region.model.District;
import com.indonesian.region.payload.RegionResponse;
import com.indonesian.region.repository.DistrictRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DistrictController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DistrictRepository districtRepository;

    @GetMapping("/districts/{regency_id}")
    public ResponseEntity<?> findByRegencyId(@PathVariable("regency_id") String regencyId) {
        List<RegionResponse> responses = convertToResponse(districtRepository.findByRegencyId(regencyId));
        return new ResponseEntity<>(responses, HttpStatus.OK);
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
