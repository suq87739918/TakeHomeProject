package com.TakeHomeProject.Exam.Controller;

import com.TakeHomeProject.Exam.Service.DfwDemoService;
import com.TakeHomeProject.Exam.Service.InterpolationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DfwDemoController {

    @Autowired
    private DfwDemoService service;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getPopulationInRadius")
    public Integer getPopulationInRadius(
            @RequestParam("lng") double lng,
            @RequestParam("lat") double lat,
            @RequestParam("radius") double radius) throws Exception {
        return service.getPopulationWithinRadius(lng, lat, radius);
    }
    @GetMapping("/getGeoJSONPolygons")
    public List<String> getGeoJSONPolygons() {
        try {
            List<String> geojsons = service.getGeoJSONPolygons();
            System.out.println("GeoJSONs: " + geojsons);
            return geojsons;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/getPolygonCentroids")
    public List<String> getPolygonCentroids() {
        return service.getPolygonCentroids();
    }

    @GetMapping("/getInterpolations")
    public List<InterpolationData> getInterpolations() {
        return service.getPolygonInterpolations();
    }

    @GetMapping("/getAverageIncomes")
    public List<Double> getAverageIncomes() {
        return service.getAverageIncomeForAllPolygons();
    }

    @GetMapping("/getIncomeAndPopulation")
    public List<Map<String, Integer>> getIncomeAndPopulation() {
        return service.getIncomeAndPopulation();
    }
}
