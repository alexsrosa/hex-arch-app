package pt.example.hexarchapp.domains.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class Account {

	private Long id;

	private String accountNumber;

	private String accountType;

	private BigDecimal currentBalance;

	private LocalDate dataOpened;

	private LocalDate dateClosed;

	private String accountStatus;

	private Customer customerId;

	private Set<Transaction> transactions;
}
