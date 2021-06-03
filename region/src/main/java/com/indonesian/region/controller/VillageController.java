package com.indonesian.region.controller;

import com.indonesian.region.model.Village;
import com.indonesian.region.payload.RegionResponse;
import com.indonesian.region.repository.VillageRepository;
import org.apache.coyote.Response;
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
public class VillageController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VillageRepository villageRepository;

    @GetMapping("/villages/{district_id}")
    public ResponseEntity<?> findByDistrictId(@PathVariable("district_id") String districtId) {
        List<RegionResponse> responses = convertToResponse(villageRepository.findByDistrictId(districtId));
        return new ResponseEntity<>(responses, HttpStatus.OK);
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
