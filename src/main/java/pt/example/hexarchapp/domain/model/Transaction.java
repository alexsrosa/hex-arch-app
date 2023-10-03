package pt.example.hexarchapp.domain.model;

import lombok.Data;
import pt.example.hexarchapp.domain.enuns.TransactionTypeEnum;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Transaction implements Serializable {

	@Serial private static final long serialVersionUID = -2268989817417018860L;

	private Long id;

	private TransactionTypeEnum transactionType;

	private BigDecimal amount;

	private LocalDateTime transactionDate;

}
