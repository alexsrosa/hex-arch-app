package pt.example.hexarchapp.adapters.input.listeners.data;

import lombok.Data;
import pt.example.hexarchapp.domains.enuns.TransactionTypeEnum;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionsMessage implements Serializable {

	@Serial private static final long serialVersionUID = -4442376090838037938L;

	public static final String QUEUE_NAME = "transactions";

	private Long id;

	private TransactionTypeEnum transactionType;

	private BigDecimal amount;

	private LocalDateTime transactionDate;
}
