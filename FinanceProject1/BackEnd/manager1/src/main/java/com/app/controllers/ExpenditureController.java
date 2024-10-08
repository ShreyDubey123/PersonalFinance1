package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Expenditure;
import com.app.service.ExpenditureService;

@RestController
@RequestMapping("/api/expenditures")
public class ExpenditureController {

    @Autowired
    private ExpenditureService expenditureService;

    @PostMapping
    public Expenditure createExpenditure(@RequestBody Expenditure expenditure) {
        return expenditureService.saveExpenditure(expenditure);
    }

    @GetMapping
    public List<Expenditure> getAllExpenditures() {
        return expenditureService.getAllExpenditures();
    }

    @GetMapping("/{id}")
    public Expenditure getExpenditureById(@PathVariable int id) {
        return expenditureService.getExpenditureById(id);
    }

    @PutMapping("/{id}")
    public Expenditure updateExpenditure(@PathVariable int id, @RequestBody Expenditure expenditure) {
        expenditure.setExpenditureId(id);
        return expenditureService.saveExpenditure(expenditure);
    }

    @DeleteMapping("/{id}")
    public void deleteExpenditure(@PathVariable int id) {
        expenditureService.deleteExpenditure(id);
    }
}
