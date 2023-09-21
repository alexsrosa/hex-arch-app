package pt.example.hexarchapp.domains.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Transaction {

	private Long id;

	private String transactionType;

	private BigDecimal amount;

	private LocalDateTime transactionDate;

}
