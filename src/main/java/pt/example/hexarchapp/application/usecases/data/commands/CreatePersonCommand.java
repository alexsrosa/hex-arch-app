package pt.example.hexarchapp.application.usecases.data.commands;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class CreatePersonCommand {

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
