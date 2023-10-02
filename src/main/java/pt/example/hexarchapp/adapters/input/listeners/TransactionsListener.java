package pt.example.hexarchapp.adapters.input.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.input.listeners.data.TransactionsMessage;
import pt.example.hexarchapp.adapters.input.listeners.mappers.TransactionsMessageMapper;
import pt.example.hexarchapp.application.usecases.SupportsTransactionUseCase;

@RequiredArgsConstructor
@Slf4j
@Component
public class TransactionsListener {

	private final SupportsTransactionUseCase supportsTransactionUseCase;

	private final TransactionsMessageMapper transactionsMessageMapper;

	@RabbitListener( queues = { "${queues.transaction.name:transactions}" } )
	public void receiveTransaction( @Payload TransactionsMessage transaction ) {
		log.info( transaction.toString() );

		supportsTransactionUseCase.create( transactionsMessageMapper.toCommand( transaction ) );
	}
}
