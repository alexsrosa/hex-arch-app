package pt.example.hexarchapp.application.usecases.data.commands;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePersonCommand implements Serializable {

    @Serial private static final long serialVersionUID = 6530643794102365169L;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    private LocalDate dateOfBirth;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String address;

    @NotEmpty
    private String taxIdentifier;
}
