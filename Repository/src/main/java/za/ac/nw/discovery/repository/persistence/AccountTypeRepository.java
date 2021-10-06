package za.ac.nw.discovery.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.ac.nw.discovery.domain.persistence.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT" +
            "       Account_Type_Id, " +
            "       Account_Type_Name," +
            "       Creation_Date," +
            "       Mnemonic" +
            "   FROM " +
            "       [dbo].[Account_Type] " +
            "   WHERE Mnemonic = :mnemonic ", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
}
