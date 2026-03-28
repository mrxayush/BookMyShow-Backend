package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.Model.Movie;
import com.cfs.BookMyShow.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
   Optional<Payment> findByTransactionId(String transactionId);

}
