package com.csm.LibraryManagementim.service;

import com.csm.LibraryManagementim.model.Library;
import com.csm.LibraryManagementim.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<String> getAllSubscriptionTypes() {
        return libraryRepository.findAllSubscriptionTypes();
    }

    public Optional<Double> getFeeBySubscriptionType(String subscription_type) {
        //Optional<Double> libraryOptional = libraryRepository.findFeeBySubscriptionType(subscription_type);
        //return libraryOptional.map(Library::getSubscription_fee).orElse(null);
        return libraryRepository.findFeeBySubscriptionType(subscription_type);
    }

    public List<Library> findAll() {
        return libraryRepository.findAll();
    }
}
