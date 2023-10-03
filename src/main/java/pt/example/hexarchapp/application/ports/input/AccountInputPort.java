package pt.example.hexarchapp.application.ports.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pt.example.hexarchapp.application.ports.output.AccountOutputPort;
import pt.example.hexarchapp.application.usecases.FetchAccountUseCase;
import pt.example.hexarchapp.application.usecases.SupportsAccountUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreateAccountCommand;
import pt.example.hexarchapp.application.usecases.mappers.AccountUseCaseMapper;
import pt.example.hexarchapp.domain.enuns.AccountStatusEnum;
import pt.example.hexarchapp.domain.enuns.AccountTypeEnum;
import pt.example.hexarchapp.domain.exceptions.AccountAlreadyClosedException;
import pt.example.hexarchapp.domain.exceptions.NotFoundException;
import pt.example.hexarchapp.domain.model.Account;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountInputPort implements SupportsAccountUseCase, FetchAccountUseCase {

    public static final String ACCOUNT_NOT_FOUND = "Account Not Found";

    private final AccountOutputPort accountOutputPort;

    private final AccountUseCaseMapper accountUseCaseMapper;

    @Override
    public Optional<Account> create(CreateAccountCommand createAccountCommand) {
        return accountOutputPort.save(accountUseCaseMapper.toData(createAccountCommand));
    }

    @Override
    public Optional<Account> changeAccountType(Long id, AccountTypeEnum accountType) {
        return accountOutputPort.changeAccountType(id, accountType);
    }

    @Transactional
    @Override
    public Optional<Account> changeAccountStatus(Long id, AccountStatusEnum accountStatus) {
        Account account = accountOutputPort.findById(id)
                .orElseThrow(() -> new NotFoundException(ACCOUNT_NOT_FOUND));

        if (Objects.equals(AccountStatusEnum.CLOSED, account.getAccountStatus())) {
            throw new AccountAlreadyClosedException();
        }

        account.setAccountStatus(accountStatus);
        account.setDateClosed(AccountStatusEnum.CLOSED.equals(accountStatus) ? LocalDate.now() : null);

        return accountOutputPort.save(account);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(accountOutputPort.findById(id)
                .orElseThrow(() -> new NotFoundException(ACCOUNT_NOT_FOUND)));
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return accountOutputPort.findByAccountNumber(accountNumber);
    }
}
