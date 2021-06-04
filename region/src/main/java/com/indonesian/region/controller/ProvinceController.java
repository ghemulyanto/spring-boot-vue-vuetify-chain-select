package com.indonesian.region.controller;

import com.indonesian.region.model.Province;
import com.indonesian.region.payload.RegionResponse;
import com.indonesian.region.repository.ProvinceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class ProvinceController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ProvinceRepository provinceRepository;

    @GetMapping("/provinces")
    public ResponseEntity<Map<String, Object>> findAll() {
        try {
            Map<String, Object> provinces = new HashMap<>();
            provinces.put("provinces", convertToResponse(provinceRepository.findAll()));
            return new ResponseEntity<>(provinces, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private List<RegionResponse> convertToResponse(List<Province> provinces) {
        List<RegionResponse> responses = new ArrayList<>();
        for (Province province : provinces) {
            RegionResponse response = modelMapper.map(province, RegionResponse.class);
            responses.add(response);
        }
        return responses;
    }
}
