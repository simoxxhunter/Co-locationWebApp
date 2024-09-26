package com.colocation.services;

import com.colocation.models.ListingsModel;
import com.colocation.repositories.ListingRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ListingServiceImpTest {

    @Mock
    private ListingRepo listingRepository;

    @InjectMocks
    private ListingServiceImp listingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMarkAsAvailable() {
        Long id = 1L;
        ListingsModel listing = new ListingsModel();
        listing.setId(id);
        listing.setAvailable(false);

        when(listingRepository.findById(id)).thenReturn(Optional.of(listing));
        when(listingRepository.save(any(ListingsModel.class))).thenReturn(listing);

        ListingsModel result = listingService.markAsAvailable(id);

        assertTrue(result.isAvailable());
        verify(listingRepository, times(1)).findById(id);
        verify(listingRepository, times(1)).save(listing);
    }

    @Test
    void testMarkAsAvailable_ListingNotFound() {
        Long id = 1L;
        when(listingRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> listingService.markAsAvailable(id));
        verify(listingRepository, times(1)).findById(id);
        verify(listingRepository, never()).save(any(ListingsModel.class));
    }

    @Test
    void testMarkAsUnavailable() {
        Long id = 1L;
        ListingsModel listing = new ListingsModel();
        listing.setId(id);
        listing.setAvailable(true);

        when(listingRepository.findById(id)).thenReturn(Optional.of(listing));
        when(listingRepository.save(any(ListingsModel.class))).thenReturn(listing);

        ListingsModel result = listingService.markAsUnavailable(id);

        assertFalse(result.isAvailable());
        verify(listingRepository, times(1)).findById(id);
        verify(listingRepository, times(1)).save(listing);
    }

    @Test
    void testMarkAsUnavailable_ListingNotFound() {
        Long id = 1L;
        when(listingRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> listingService.markAsUnavailable(id));
        verify(listingRepository, times(1)).findById(id);
        verify(listingRepository, never()).save(any(ListingsModel.class));
    }
}