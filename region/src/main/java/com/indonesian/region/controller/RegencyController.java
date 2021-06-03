package com.indonesian.region.controller;

import com.indonesian.region.model.Regency;
import com.indonesian.region.payload.RegionResponse;
import com.indonesian.region.repository.RegencyRepository;
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
public class RegencyController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RegencyRepository regencyRepository;


    @GetMapping("/regencies/{province_id}")
    public ResponseEntity<?> findByProvinceId(@PathVariable("province_id") String provinceId) {
        List<RegionResponse> regencies = convertToResponse(regencyRepository.findByProvinceId(provinceId));
        return new ResponseEntity<>(regencies, HttpStatus.OK);
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
