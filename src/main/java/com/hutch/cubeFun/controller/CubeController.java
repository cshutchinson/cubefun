package com.hutch.cubeFun.controller;

import com.hutch.cubeFun.model.CubeFunRequest;
import com.hutch.cubeFun.service.CubeFunService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CubeController {
    @Autowired
    private CubeFunService cubeFunService;

    @PostMapping("/request")
    public int anaylyze(@RequestBody CubeFunRequest request){
        return cubeFunService.analyze(request.getSlice());
    }

}
