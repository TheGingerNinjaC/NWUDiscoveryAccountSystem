package za.ac.nw.discovery.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import za.ac.nw.discovery.domain.dto.AccountDto;
import za.ac.nw.discovery.domain.persistence.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Query(value = "UPDATE [dbo].[Account] " +
            "   SET [Balance] = :balance " +
            "   WHERE [Account_Id] = :account ", nativeQuery = true)
    void updateAccountBalance(Long account, Double balance);
}
