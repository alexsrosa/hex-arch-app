package pt.example.hexarchapp.application.usecases.data.commands;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.example.hexarchapp.domains.enuns.AccountStatusEnum;

import java.io.Serial;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeAccountStatusCommand implements Serializable {

	@Serial private static final long serialVersionUID = 5395451760456661271L;

	@NotNull
	private AccountStatusEnum accountStatus;

}
