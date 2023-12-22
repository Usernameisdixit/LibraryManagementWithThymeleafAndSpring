package com.csm.LibraryManagementim.repository;

import com.csm.LibraryManagementim.model.Library;
import com.csm.LibraryManagementim.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByLibraryIn(List<Library> libraries);


}
