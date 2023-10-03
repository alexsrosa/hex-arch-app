package pt.example.hexarchapp.adapters.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pt.example.hexarchapp.adapters.output.persistence.data.AccountData;
import pt.example.hexarchapp.domain.enuns.AccountTypeEnum;

import java.util.Optional;

@Repository
public interface AccountJPARepository extends JpaRepository<AccountData, Long> {

	Optional<AccountData> findByAccountNumber( String accountNumber );

	Optional<AccountData> findByCustomer_Id( Long customerId );

	@Modifying
	@Query( value = "UPDATE AccountData a Set a.accountType = :accountType where a.id = :id" )
	Optional<AccountData> changeAccountType( Long id, AccountTypeEnum accountType );
}
