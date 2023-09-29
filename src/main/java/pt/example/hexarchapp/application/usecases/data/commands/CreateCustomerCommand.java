package pt.example.hexarchapp.application.usecases.data.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.example.hexarchapp.domains.enuns.CustomerTypeEnum;

import java.io.Serial;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerCommand implements Serializable {

    @Serial private static final long serialVersionUID = 1596908607339473464L;

    private CustomerTypeEnum customerType;

    private Long personId;

}
