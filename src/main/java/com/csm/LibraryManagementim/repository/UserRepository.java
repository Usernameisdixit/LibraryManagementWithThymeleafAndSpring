package com.csm.LibraryManagementim.repository;

import com.csm.LibraryManagementim.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {



}
