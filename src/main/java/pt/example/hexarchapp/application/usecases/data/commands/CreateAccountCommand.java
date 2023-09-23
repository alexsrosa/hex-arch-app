package pt.example.hexarchapp.application.usecases.data.commands;

import lombok.Data;
import pt.example.hexarchapp.domains.enuns.AccountStatusEnum;
import pt.example.hexarchapp.domains.enuns.AccountTypeEnum;
import pt.example.hexarchapp.domains.model.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateAccountCommand {

	private String accountNumber;

	private AccountTypeEnum accountType;

	private BigDecimal currentBalance;

	private LocalDate dataOpened;

	private LocalDate dateClosed;

	private AccountStatusEnum accountStatus;

	private Customer customerId;

}
