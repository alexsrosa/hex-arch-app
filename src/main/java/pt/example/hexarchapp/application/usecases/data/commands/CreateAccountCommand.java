package pt.example.hexarchapp.application.usecases.data.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.example.hexarchapp.domain.enuns.AccountStatusEnum;
import pt.example.hexarchapp.domain.enuns.AccountTypeEnum;
import pt.example.hexarchapp.domain.model.Customer;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAccountCommand implements Serializable {

	@Serial private static final long serialVersionUID = -8257045172456614231L;

	private String accountNumber;

	private AccountTypeEnum accountType;

	private BigDecimal currentBalance;

	private LocalDate dataOpened;

	private LocalDate dateClosed;

	private AccountStatusEnum accountStatus;

	private Customer customerId;

}
