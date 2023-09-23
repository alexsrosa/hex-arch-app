package pt.example.hexarchapp.domains.model;

import lombok.Data;
import pt.example.hexarchapp.domains.enuns.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Transaction {

	private Long id;

	private TransactionTypeEnum transactionType;

	private BigDecimal amount;

	private LocalDateTime transactionDate;

}
