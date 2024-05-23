
package com.example.demo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VenueRepository extends JpaRepository<Venue, Long> {
    List<Venue> findByVenueName(String venueName);
}

