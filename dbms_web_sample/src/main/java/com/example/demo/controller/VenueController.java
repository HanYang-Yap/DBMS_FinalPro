
package com.example.demo.controller;

import com.example.demo.model.Venue;
import com.example.demo.service.VenueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    @Autowired
    private VenueService venueService;

    @GetMapping
    public List<Venue> listAllVenues(@RequestParam(required = false, name = "venueName") String venueName) {
        if (venueName != null) {
            return venueService.findByVenueName(venueName);
        } else {
            return venueService.getAllVenues();
        }
    }

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable("id") Long id) {
        return venueService.getVenueById(id);
    }

    @PostMapping
    public Venue createProduct(@RequestBody Venue venue) {
        System.out.println(venue.getVenue_name());
        return venueService.createVenue(venue);
    }

    @PutMapping("/{id}")
    public Venue updateVenue( @RequestBody Venue venue) {
        return venueService.updateVenue(venue);
    }

    @DeleteMapping("/{id}")
    public void deleteVenue(@PathVariable("id") Long id) {
        venueService.deleteVenue(id);
    }
}