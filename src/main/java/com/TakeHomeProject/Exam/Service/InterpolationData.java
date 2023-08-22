package com.TakeHomeProject.Exam.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterpolationData {
    private String geoJSON;
    private String centroid;
    private double interpolation;
}
