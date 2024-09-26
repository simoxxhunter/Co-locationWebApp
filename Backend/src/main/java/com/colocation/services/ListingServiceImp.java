package com.colocation.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.colocation.repositories.ListingRepo;
import org.springframework.stereotype.Service;
import com.colocation.models.ListingsModel;

import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImp implements ListingService {

    private final ListingRepo listingRepository;

    @Autowired
    public ListingServiceImp(ListingRepo listingRepository) {
        this.listingRepository = listingRepository;
    }

    public ListingsModel createListing(ListingsModel listing) {
        return listingRepository.save(listing);
    }

    public Optional<ListingsModel> getListingById(Long id) {
        return listingRepository.findById(id);
    }

    public List<ListingsModel> getAllListings() {
        return listingRepository.findAll();
    }

    public ListingsModel updateListing(Long id, ListingsModel updatedListing) {
        return listingRepository.findById(id)
                .map(existingListing -> {
                    existingListing.setTitle(updatedListing.getTitle());
                    existingListing.setDescription(updatedListing.getDescription());
                    existingListing.setRent(updatedListing.getRent());
                    existingListing.setBedrooms(updatedListing.getBedrooms());
                    existingListing.setBathrooms(updatedListing.getBathrooms());
                    existingListing.setAddress(updatedListing.getAddress());
                    existingListing.setAmenities(updatedListing.getAmenities());
                    existingListing.setPhotos(updatedListing.getPhotos());
                    return listingRepository.save(existingListing);
                })
                .orElseThrow(() -> new RuntimeException("Listing not found"));
    }

    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

    public ListingsModel markAsUnavailable(Long listingId) {
        Optional<ListingsModel> optionalListing = listingRepository.findById(listingId);
        if (optionalListing.isPresent()) {
            ListingsModel existingListing = optionalListing.get();
            existingListing.setAvailable(false);
            return listingRepository.save(existingListing);
        } else {
            throw new RuntimeException("Listing not found");
        }
    }

    public ListingsModel markAsAvailable(Long id) {
        Optional<ListingsModel> optionalListing = listingRepository.findById(id);
        if (optionalListing.isPresent()) {
            ListingsModel existingListing = optionalListing.get();
            existingListing.setAvailable(true);
            return listingRepository.save(existingListing);
        } else {
            throw new RuntimeException("Listing not found");
        }
    }


}