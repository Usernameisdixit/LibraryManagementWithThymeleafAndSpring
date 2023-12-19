package com.csm.LibraryManagementim.repository;

import com.csm.LibraryManagementim.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library,Long> {

    @Query("SELECT DISTINCT subscription_type FROM Library")
    List<String> findAllSubscriptionTypes();

    @Query("SELECT DISTINCT l.subscription_fee FROM Library l WHERE l.subscription_type = :subscription_type")
    Optional<Double> findFeeBySubscriptionType(@Param("subscription_type") String subscription_type);


        //Optional<Library> findFeeBySubscriptionType(String subscription_type);

}
