package com.ncs.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.api.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	@Query("from User where name = :username")
	public User getUsersByUsername(String username);

}
