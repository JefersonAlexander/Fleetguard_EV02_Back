package com.microservice.fleetLocation.repository;

import com.microservice.fleetLocation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
