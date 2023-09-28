package pt.example.hexarchapp.adapters.input.endpoints.data;

import pt.example.hexarchapp.application.usecases.data.commands.CreatePersonCommand;

import java.time.LocalDate;

public interface CreatePersonCommandData {

    default CreatePersonCommand getCreatePersonCommand() {
        return CreatePersonCommand.builder()
                .firstName("First Name")
                .lastName("Last Name")
                .dateOfBirth(LocalDate.now().minusYears(18))
                .email("example@example.pt")
                .phoneNumber("999888555")
                .address("Avenue one")
                .taxIdentifier("895854848")
                .build();
    }
}
