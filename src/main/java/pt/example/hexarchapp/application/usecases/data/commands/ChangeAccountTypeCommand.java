package pt.example.hexarchapp.application.usecases.data.commands;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pt.example.hexarchapp.domains.enuns.AccountTypeEnum;

@Data
public class ChangeAccountTypeCommand {

	@NotNull
	private AccountTypeEnum accountTypeEnum;

}
