package pt.example.hexarchapp.adapters.output.persistence.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.adapters.output.persistence.data.AccountData;
import pt.example.hexarchapp.domain.model.Account;

@Mapper( componentModel = "spring" )
public interface AccountMapper {

	AccountData toData( Account account );

	Account toDomain( AccountData accountData );
}
