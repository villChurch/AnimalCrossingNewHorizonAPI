package com.williamspires.acnhapi.Repositories;

import com.williamspires.acnhapi.Model.Reactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reactions, String> {

    Reactions findReactionsByName(String name);

    List<Reactions> findReactionsBySource(String source);
}
