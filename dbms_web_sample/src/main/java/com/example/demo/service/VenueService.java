package com.example.demo.service;

import com.example.demo.model.Venue;
import com.example.demo.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {

    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public List<Venue> getUsers() {
        return venueRepository.findAll();
    }

    public List<Venue> findByVenueId(Long venueId) {
        return venueRepository.findByVenueId(venueId);
    }

    public List<Venue> findByVenueName(String venueName) {
        return venueRepository.findByVenueName(venueName);
    }

    public Venue createUser(Venue user) {
        return venueRepository.save(user);
    }

    public Venue updateUser(Venue user) {
        return venueRepository.save(user);
    }

    public void deleteVenue(Long id) {
        venueRepository.deleteById(id);
    }
}