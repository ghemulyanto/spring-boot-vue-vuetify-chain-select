package com.indonesian.region.controller;

import com.indonesian.region.model.Province;
import com.indonesian.region.payload.RegionResponse;
import com.indonesian.region.repository.ProvinceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProvinceController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ProvinceRepository provinceRepository;

    @GetMapping("/provinces")
    public List<RegionResponse> findAll() {
        return convertToResponse(provinceRepository.findAll());
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
