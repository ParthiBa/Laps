package com.team6.LapsApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.team6.LapsApp.model.Holiday;

public interface HolidayReposistory extends CrudRepository<Holiday, String> {

}
