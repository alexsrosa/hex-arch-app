package pt.example.hexarchapp.application.ports.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.example.hexarchapp.application.ports.output.CustomerOutputPort;
import pt.example.hexarchapp.application.usecases.FetchCustomerUseCase;
import pt.example.hexarchapp.application.usecases.SupportsCustomerUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreateCustomerCommand;
import pt.example.hexarchapp.application.usecases.mappers.CustomerUseCaseMapper;
import pt.example.hexarchapp.domain.exceptions.NotFoundException;
import pt.example.hexarchapp.domain.model.Customer;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerInputPort implements SupportsCustomerUseCase, FetchCustomerUseCase {

    public static final String CUSTOMER_NOT_FOUND = "Customer Not Found";

    private final CustomerOutputPort customerOutputPort;

    private final CustomerUseCaseMapper customerUseCaseMapper;

    @Override
    public Optional<Customer> create(CreateCustomerCommand createCustomerCommand) {
        return customerOutputPort.save(customerUseCaseMapper.toData(createCustomerCommand));
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customerOutputPort.findById(id)
                .orElseThrow(() -> new NotFoundException(CUSTOMER_NOT_FOUND)));
    }
}
