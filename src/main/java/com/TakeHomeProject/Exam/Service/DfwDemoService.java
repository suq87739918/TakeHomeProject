package com.TakeHomeProject.Exam.Service;

import com.TakeHomeProject.Exam.Repository.DfwDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DfwDemoService {
    @Autowired
    private DfwDemoRepository repository;
    // Any other service methods

    public Integer getPopulationWithinRadius(double x, double y, double radius) {
        return repository.findPopulationWithinRadius(x, y, radius);
    }
//    public Double getAverageIncomeWithinRadius(double x, double y, double radius) {
//        return repository.findAverageIncomeWithinRadius(x, y, radius);
//    }
}

