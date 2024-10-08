package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ExpenditureRepository;
import com.app.entity.Expenditure;

@Service
@Transactional
public class ExpenditureService {

	@Autowired
    private ExpenditureRepository expenditureRepository;

    public Expenditure saveExpenditure(Expenditure expenditure) {
        return expenditureRepository.save(expenditure);
    }

    public List<Expenditure> getAllExpenditures() {
        return (List<Expenditure>) expenditureRepository.findAll();
    }

    public Expenditure getExpenditureById(Integer id) {
        return expenditureRepository.findById(id).orElse(null);
    }

    public void deleteExpenditure(Integer id) {
        expenditureRepository.deleteById(id);
    }
}
