package com.example.messenger.repository;
import com.example.messenger.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
    @Query("SELECT g.id FROM Group g")
    List<String> findAllGroupIds();
}
