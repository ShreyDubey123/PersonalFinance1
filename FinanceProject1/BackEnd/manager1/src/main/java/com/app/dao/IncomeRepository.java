package com.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.Income;

public interface IncomeRepository extends CrudRepository<Income, Integer> {

}
