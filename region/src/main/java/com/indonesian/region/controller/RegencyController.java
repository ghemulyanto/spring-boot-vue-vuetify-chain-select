package com.indonesian.region.controller;

import com.indonesian.region.model.Regency;
import com.indonesian.region.payload.RegionResponse;
import com.indonesian.region.repository.RegencyRepository;
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
public class RegencyController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RegencyRepository regencyRepository;

    @GetMapping("/regencies/{province_id}")
    public ResponseEntity<Map<String, Object>> findByProvinceId(@PathVariable("province_id") String provinceId) {
        try {
            Map<String, Object> regencies = new HashMap<>();
            regencies.put("regencies", convertToResponse(regencyRepository.findByProvinceId(provinceId)));
            return new ResponseEntity<>(regencies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private List<RegionResponse> convertToResponse(List<Regency> regencies) {
        List<RegionResponse> regencyResponses = new ArrayList<>();
        for (Regency regency : regencies) {
            RegionResponse response = modelMapper.map(regency, RegionResponse.class);
            regencyResponses.add(response);
        }
        return regencyResponses;
    }
}
