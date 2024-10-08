package com.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.Expenditure;


public interface ExpenditureRepository extends CrudRepository<Expenditure, Integer> {

}
