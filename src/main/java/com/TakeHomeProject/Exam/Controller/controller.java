package com.TakeHomeProject.Exam.Controller;

import com.TakeHomeProject.Exam.Service.DfwDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    private DfwDemoService service;

    @GetMapping("/getPopulationInRadius")
    public Integer getPopulationInRadius(
            @RequestParam("x") double x,
            @RequestParam("y") double y,
            @RequestParam("radius") double radius) {
        return service.getPopulationWithinRadius(x, y, radius);
    }
}


