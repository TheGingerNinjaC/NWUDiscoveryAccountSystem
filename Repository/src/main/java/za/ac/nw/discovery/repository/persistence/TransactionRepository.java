package za.ac.nw.discovery.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nw.discovery.domain.persistence.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
