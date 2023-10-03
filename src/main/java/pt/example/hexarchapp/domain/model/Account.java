package pt.example.hexarchapp.domain.model;

import lombok.Data;
import pt.example.hexarchapp.domain.enuns.AccountStatusEnum;
import pt.example.hexarchapp.domain.enuns.AccountTypeEnum;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class Account implements Serializable {

	@Serial private static final long serialVersionUID = 3416097458377598325L;

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
