package pt.example.hexarchapp.application.usecases.data.commands;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pt.example.hexarchapp.domains.enuns.AccountStatusEnum;

@Data
public class ChangeAccountStatusCommand {

	@NotNull
	private AccountStatusEnum accountStatus;

}
