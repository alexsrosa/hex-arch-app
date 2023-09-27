package pt.example.hexarchapp.application.usecases.data.commands;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePersonCommand {

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String email;

    private String phoneNumber;

    private String address;

    private String taxIdentifier;
}
