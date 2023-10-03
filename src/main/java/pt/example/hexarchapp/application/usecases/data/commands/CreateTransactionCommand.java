package pt.example.hexarchapp.application.usecases.data.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.example.hexarchapp.domain.enuns.TransactionTypeEnum;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTransactionCommand implements Serializable {

	@Serial private static final long serialVersionUID = 2581164337817466479L;

	private TransactionTypeEnum transactionType;

	private BigDecimal amount;

	private LocalDateTime transactionDate;
}
