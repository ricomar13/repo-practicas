package clonesKamino.controllers;


import clonesKamino.domain.CloneTrooper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloneRepository extends JpaRepository<CloneTrooper, Integer> {

}
