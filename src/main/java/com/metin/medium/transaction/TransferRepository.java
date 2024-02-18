package com.metin.medium.transaction;

import com.metin.medium.transaction.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Customer, String> {
    @Override
    Optional<Customer> findById(String username);
}
