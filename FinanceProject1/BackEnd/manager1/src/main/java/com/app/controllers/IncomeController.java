package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.entity.Income;
import com.app.service.IncomeService;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeService.saveIncome(income);
    }

    @GetMapping
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @GetMapping("/{id}")
    public Income getIncomeById(@PathVariable int id) {
        return incomeService.getIncomeById(id);
    }

    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable int id, @RequestBody Income income) {
        income.setIncomeId(id);
        return incomeService.saveIncome(income);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable int id) {
        incomeService.deleteIncome(id);
    }
}
