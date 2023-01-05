package com.example.backend.repositories;

import com.example.backend.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HumanRepositories extends JpaRepository<Human, Integer> {

}
