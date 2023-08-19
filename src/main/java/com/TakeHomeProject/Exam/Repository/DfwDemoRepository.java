package com.TakeHomeProject.Exam.Repository;

import com.TakeHomeProject.Exam.Entity.dfwDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DfwDemoRepository extends JpaRepository<dfwDemo, String> {
    @Query(value = "SELECT SUM(population) FROM dfw_demo WHERE ST_DWithin(spatialobj, ST_SetSRID(ST_MakePoint(:x, :y), 4326), :radius)", nativeQuery = true)
    Integer findPopulationWithinRadius(@Param("x") double x, @Param("y") double y, @Param("radius") double radius);

//    @Query(value = "SELECT AVG(income) FROM dfwDemo WHERE ST_DWithin(spatialobj, ST_MakePoint(:x, :y), :radius)")
//    Double findAverageIncomeWithinRadius(@Param("x") double x, @Param("y") double y, @Param("radius") double radius);

    //这是PostGIS提供的一个空间函数，用于筛选出与给定点的给定距离内的所有地理对象
}
