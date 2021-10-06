package za.ac.nw.discovery.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nw.discovery.domain.persistence.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}
