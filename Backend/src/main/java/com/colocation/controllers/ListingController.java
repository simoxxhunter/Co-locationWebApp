package com.colocation.controllers;

import com.colocation.models.ListingsModel;
import com.colocation.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200/")

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping("/createListing")
    @ResponseStatus(HttpStatus.CREATED)
    public ListingsModel createListing(@RequestBody ListingsModel listing) {
        return listingService.createListing(listing);
    }

    @GetMapping("/{id}")
    public Optional<ListingsModel> getListingById(@PathVariable Long id) {
        return listingService.getListingById(id);
    }

    @GetMapping
    public List<ListingsModel> getAllListings() {
        return listingService.getAllListings();
    }

    @PutMapping("/{id}")
    public ListingsModel updateListing(@PathVariable Long id, @RequestBody ListingsModel updatedListing) {
        return listingService.updateListing(id, updatedListing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteListing(@PathVariable Long id) {
        listingService.deleteListing(id);
    }

    @PatchMapping("/{id}/unavailable")
    public ListingsModel markAsUnavailable(@PathVariable Long id) {
        return listingService.markAsUnavailable(id);
    }

    @PatchMapping("/{id}/available")
    public ListingsModel markAsAvailable(@PathVariable Long id) {
        return listingService.markAsAvailable(id);
    }
}