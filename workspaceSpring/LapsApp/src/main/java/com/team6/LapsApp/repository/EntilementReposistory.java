package com.team6.LapsApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.team6.LapsApp.model.Entitlement;
import com.team6.LapsApp.model.EntitlementId;

public interface EntilementReposistory extends CrudRepository<Entitlement, EntitlementId> {

}
