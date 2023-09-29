package pt.example.hexarchapp.application.usecases.data.commands;

import lombok.Data;
import pt.example.hexarchapp.domains.enuns.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateTransactionCommand {

    private TransactionTypeEnum transactionType;

    private BigDecimal amount;

    private LocalDateTime transactionDate;
}
