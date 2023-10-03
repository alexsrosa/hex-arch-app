package pt.example.hexarchapp.application.usecases.data.commands;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.example.hexarchapp.domain.enuns.AccountTypeEnum;

import java.io.Serial;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeAccountTypeCommand implements Serializable {

	@Serial private static final long serialVersionUID = 6587270345633670738L;

	@NotNull
	private AccountTypeEnum accountTypeEnum;

}
