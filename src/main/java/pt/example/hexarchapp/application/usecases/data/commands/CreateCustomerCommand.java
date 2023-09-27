package pt.example.hexarchapp.application.usecases.data.commands;

import lombok.Data;
import pt.example.hexarchapp.domains.enuns.CustomerTypeEnum;

@Data
public class CreateCustomerCommand {

    private CustomerTypeEnum customerType;

    private Long personId;

}
