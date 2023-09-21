package pt.example.hexarchapp.adapters.output.persistence.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.adapters.output.persistence.data.TransactionData;
import pt.example.hexarchapp.domains.model.Transaction;

@Mapper( componentModel = "spring" )
public interface TransactionMapper {

	TransactionData toData( Transaction transaction );

	Transaction toDomain( TransactionData transactionData );
}
