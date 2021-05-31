package io.celeiro.algalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.celeiro.algalog.domain.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
