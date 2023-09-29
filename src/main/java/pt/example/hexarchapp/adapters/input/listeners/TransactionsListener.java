package pt.example.hexarchapp.adapters.input.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.application.usecases.SupportsTransactionUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreateTransactionCommand;

@RequiredArgsConstructor
@Slf4j
@Component
public class TransactionsListener {

	private final SupportsTransactionUseCase supportsTransactionUseCase;

	@RabbitListener( queues = { "${queues.transaction.name:transactions}" } )
	public void receiveTransaction( @Payload String transaction ) {
		log.info( transaction );

		supportsTransactionUseCase.create( CreateTransactionCommand.builder().build() );
	}
}
