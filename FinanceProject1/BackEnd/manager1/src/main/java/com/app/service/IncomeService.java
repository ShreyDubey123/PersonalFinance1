package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IncomeRepository;
import com.app.entity.Income;

@Service
@Transactional
public class IncomeService {

	@Autowired
    private IncomeRepository incomeRepository;

    public Income saveIncome(Income income) {
        return incomeRepository.save(income);
    }

    public List<Income> getAllIncomes() {
        return (List<Income>) incomeRepository.findAll();
    }

    public Income getIncomeById(Integer id) {
        return incomeRepository.findById(id).orElse(null);
    }

    public void deleteIncome(Integer id) {
        incomeRepository.deleteById(id);
    }
}
