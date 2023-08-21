package com.TakeHomeProject.Exam.Service;

import com.TakeHomeProject.Exam.Repository.DfwDemoRepository;
import org.geolatte.geom.Feature;
import org.geolatte.geom.FeatureCollection;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wololo.jts2geojson.GeoJSONWriter;

import org.locationtech.jts.geom.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DfwDemoService {
    @Autowired
    private DfwDemoRepository repository;

    public Integer getPopulationWithinRadius(double lng, double lat, double radius) throws Exception {
        // 使用 WKTReader 创建一个基于 lng 和 lat 的 Point 对象
        WKTReader reader = new WKTReader();
        Point point;
        try {
            point = (Point) reader.read("POINT (" + lng + " " + lat + ")");
        } catch (ParseException e) {
            throw new Exception("Error parsing the given lng and lat into a Point geometry.", e);
        }

        double x = point.getX();
        double y = point.getY();

        return repository.findPopulationWithinRadius(x, y, radius);
    }

    public List<String> getGeoJSONPolygons() {
        List<String> geojsons = repository.findGeoJSONPolygons();
        for (String geojson : geojsons) {
            System.out.println(geojson);
        }
        return geojsons;
    }
    public List<String> getPolygonCentroids() {
        return repository.findPolygonCentroids();
    }

}
