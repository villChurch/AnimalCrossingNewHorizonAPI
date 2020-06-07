package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.acnhevents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcnhEventsRepository extends JpaRepository<acnhevents, String> {

    List<acnhevents> findEventsByEvent(String event);

    @Query(value="select * from acnhevents", nativeQuery=true)
    List<acnhevents> getAllEvents();
}
