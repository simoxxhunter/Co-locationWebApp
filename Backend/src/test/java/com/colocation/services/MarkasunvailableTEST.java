package com.colocation.services;



import com.colocation.models.ListingsModel;
import com.colocation.repositories.ListingRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MarkasunvailableTEST {

    @Mock
    private ListingRepo listingRepository;

    @InjectMocks
    private ListingsModel listingsModel;

    @Test
    void testMarkAsUnavailable() {
        Long listingId = 1L;
        ListingsModel existingListing = ListingsModel.builder()
                .id(listingId)
                .available(true)
                .build();

        when(listingRepository.findById(listingId)).thenReturn(Optional.of(existingListing));
        when(listingRepository.save(existingListing)).thenReturn(existingListing);

        listingsModel.markAsUnavailable(listingId);

        assertFalse(existingListing.isAvailable());
        verify(listingRepository, times(1)).findById(listingId);
        verify(listingRepository, times(1)).save(existingListing);
    }

    @Test
    void testMarkAsUnavailable_WhenListingNotFound() {
        Long listingId = 1L;
        when(listingRepository.findById(listingId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> listingsModel.markAsUnavailable(listingId));
        verify(listingRepository, times(1)).findById(listingId);
        verify(listingRepository, never()).save(any());
    }
}