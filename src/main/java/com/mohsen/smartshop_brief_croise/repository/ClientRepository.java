package com.mohsen.smartshop_brief_croise.repository;

import com.mohsen.smartshop_brief_croise.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
