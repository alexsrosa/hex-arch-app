package pt.example.hexarchapp.domains.model;

import lombok.Data;
import pt.example.hexarchapp.domains.enuns.AccountStatusEnum;
import pt.example.hexarchapp.domains.enuns.AccountTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class Account {

	private Long id;

	private String accountNumber;

	private AccountTypeEnum accountType;

	private BigDecimal currentBalance;

	private LocalDate dataOpened;

	private LocalDate dateClosed;

	private AccountStatusEnum accountStatus;

	private Customer customerId;

	private Set<Transaction> transactions;
}
