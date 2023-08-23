package com.TakeHomeProject.Exam.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.postgis.jdbc.geometry.Geometry;

@Entity
@Table(name = "dfw_demo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DfwDemoEntity {
    @Id
    @Column(length = 32)
    private String key;

    @Column(name = "income")
    private Integer income;

    @Column(name = "population")
    private Integer population;

    @Column(name = "spatialobj")
    //@Type(type = "org.hibernate.spatial.GeometryType")
    private Geometry spatialobj;
}
