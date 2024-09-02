package com.colocation.controllers;

import com.colocation.models.ListingsModel;
import com.colocation.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listings")
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping
    public ListingsModel createListing(@RequestBody ListingsModel listing) {
        return listingService.createListing(listing);
    }

    @GetMapping("/{id}")
    public ListingsModel getListingById(@PathVariable Long id) {
        Optional<ListingsModel> listing = listingService.getListingById(id);
        return listing.orElse(null);
    }

    @GetMapping
    public List<ListingsModel> getAllListings() {
        return listingService.getAllListings();
    }

    @PutMapping("/{id}")
    public ListingsModel updateListing(@PathVariable Long id, @RequestBody ListingsModel updatedListing) {
        Optional<ListingsModel> existingListing = listingService.getListingById(id);
        if (existingListing.isPresent()) {
            return listingService.updateListing(id, updatedListing);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
    }

    @PatchMapping("/{id}/unavailable")
    public ListingsModel markAsUnavailable(@PathVariable Long id) {
        Optional<ListingsModel> existingListing = listingService.getListingById(id);
        if (existingListing.isPresent()) {
            return listingService.markAsUnavailable(id);
        } else {
            return null;
        }
    }
}
