package com.TakeHomeProject.Exam.Repository;

import com.TakeHomeProject.Exam.Entity.DfwDemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DfwDemoRepository extends JpaRepository<DfwDemoEntity, String> {
    @Query(value = "SELECT SUM(population) FROM dfw_demo WHERE ST_DWithin(CAST(spatialobj AS geography), CAST(ST_SetSRID(ST_MakePoint(:x, :y), 4326) AS geography), :radius)", nativeQuery = true)
    Integer findPopulationWithinRadius(@Param("x") double x, @Param("y") double y, @Param("radius") double radius);


    @Query(value = "SELECT ST_AsGeoJSON(spatialobj) FROM dfw_demo", nativeQuery = true)
    List<String> findGeoJSONPolygons();

    @Query(value = "SELECT ST_AsGeoJSON(ST_Centroid(spatialobj)) FROM dfw_demo", nativeQuery = true)
    List<String> findPolygonCentroids();
}
