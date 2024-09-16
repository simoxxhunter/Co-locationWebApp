package com.colocation.services;


import com.colocation.models.ListingsModel;

import java.util.List;
import java.util.Optional;

public interface ListingService {

    ListingsModel createListing(ListingsModel listing);
    Optional<ListingsModel> getListingById(Long id);
    List<ListingsModel> getAllListings();
    ListingsModel updateListing(Long id, ListingsModel updatedListing);
    void deleteListing(Long id);
    ListingsModel markAsUnavailable(Long id);
    ListingsModel markAsAvailable(Long id);
}
